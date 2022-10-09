package com.cadu.sacola.resource;

import com.cadu.sacola.model.Item;
import com.cadu.sacola.model.Sacola;
import com.cadu.sacola.resource.dto.ItemDto;
import com.cadu.sacola.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood/sacolas")
@RequiredArgsConstructor
public class SacolaResource {
    private final SacolaService sacolaService;


    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
       return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id){
        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId, @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }
}
