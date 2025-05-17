package br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints;

import java.util.List;

public record CollectionPointRequestDto (String name, String address, String collectionPeriod, List<CollectionPointMaterialRequestDto> materials) {
}
