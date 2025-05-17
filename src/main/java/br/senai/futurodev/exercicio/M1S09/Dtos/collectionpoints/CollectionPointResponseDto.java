package br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints;

import java.util.List;

public record CollectionPointResponseDto(Long id, String name, String address, String collectionPeriod, List<CollectionPointMaterialRequestDto> materials) {
}
