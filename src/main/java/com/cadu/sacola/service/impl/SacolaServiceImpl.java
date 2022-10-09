package com.cadu.sacola.service.impl;

import com.cadu.sacola.enumeration.FormaPagamento;
import com.cadu.sacola.model.Item;
import com.cadu.sacola.model.Restaurante;
import com.cadu.sacola.model.Sacola;
import com.cadu.sacola.repository.ItemRepository;
import com.cadu.sacola.repository.ProdutoRepository;
import com.cadu.sacola.repository.SacolaRepository;
import com.cadu.sacola.resource.dto.ItemDto;
import com.cadu.sacola.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SacolaServiceImpl implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;

    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        //Recupera a sacola para adicionar o item
        Sacola sacola = verSacola(itemDto.getIdSacola());

        //Confere se a sacola está fechada
        if(sacola.isFechada()){
            throw new RuntimeException("Esta sacola está fechada.");
        }

        //Item para inserir na sacola
        Item itemParaSerInserido = Item.builder()
                .quantidade(itemDto.getQuantidade())
                .sacola(sacola)
                //confere se o produto existe no banco de dados
                .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                    () -> {
                        throw new RuntimeException("Esse produto não existe!");
                    }
                    ))
            .build();

        List<Item> itensDaSacola = sacola.getItens();
        //confere se a sacola está vazia
        if(itensDaSacola.isEmpty()) {
            itensDaSacola.add(itemParaSerInserido);
        } else{
            //Se a sacola não está vazia confere se o produto a ser adicionado é do mesmo restaurante
            Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
            Restaurante restauranteDoItemParaAdicionar = itemParaSerInserido.getProduto().getRestaurante();
            if(restauranteAtual.equals(restauranteDoItemParaAdicionar)){
                itensDaSacola.add(itemParaSerInserido);
            } else {
                //caso o produto seja de um restaurante diferente lança uma exception
                throw new RuntimeException("Não é possivel adicionar produtos de restaurantes diferentes. feche a sacola ou esvazie.");
            }
        }

        //Calcula o valor da sacola
        List<Double> valorDosItens = new ArrayList<>();
        //Percorre todos itens da sacola pegando o valor unitario e multiplicando pela quantidade
        for(Item itemDaSacola: itensDaSacola){
            double valorTotalItem = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
            valorDosItens.add(valorTotalItem);
        }

        //1 forma - percorre a lista e soma na sacola
        /*Double valorTotalSacola = 0.0;
        for(Double valorDeCadaItem : valorDosItens){
            valorTotalSacola += valorDeCadaItem;
        }*/

        //2 forma - usando stream para percorrer os itens e somar o valor
        double valorTotalSacola = valorDosItens.stream()
                .mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
                .sum();

        //coloca a soma na sacola
        sacola.setValorTotal(valorTotalSacola);
        //salva a sacola
        sacolaRepository.save(sacola);
        //salva o item que foi adicionado na sacola
        return itemRepository.save(itemParaSerInserido);
    }

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Essa sacola não existe!");
                }
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int numeroFormaPagamento) {
        Sacola sacola = verSacola(id);
        //Verifica se a sacola está vazia para fechar
        if(sacola.getItens().isEmpty()){
            throw new RuntimeException("Inclua itens na sacola!");
        }

        FormaPagamento formaPagamento
                = numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;

        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);
    }
}
