package com.cadu.sacola.service;

import com.cadu.sacola.model.Item;
import com.cadu.sacola.model.Sacola;
import com.cadu.sacola.resource.dto.ItemDto;

public interface SacolaService {
    Item incluirItemNaSacola(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagamento);

}
