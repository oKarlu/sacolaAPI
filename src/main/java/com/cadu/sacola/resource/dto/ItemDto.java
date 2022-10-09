package com.cadu.sacola.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class ItemDto {
    private Long produtoId;
    private int quantidade;
    private Long idSacola;
}
