package br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints;

import br.senai.futurodev.exercicio.M1S09.entities.EletronicWaste;

import java.math.BigDecimal;

public record CollectionPointMaterialResponseDto (Long id, EletronicWasteResponseDto eletronicWaste, BigDecimal maxCapacity){
}
