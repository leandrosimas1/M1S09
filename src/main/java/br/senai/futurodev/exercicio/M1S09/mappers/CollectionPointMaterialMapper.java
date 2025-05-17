package br.senai.futurodev.exercicio.M1S09.mappers;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointMaterialResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.CollectionPointMaterial;
import br.senai.futurodev.exercicio.M1S09.entities.EletronicWaste;

import java.util.List;

public class CollectionPointMaterialMapper {

    private CollectionPointMaterialMapper() {
    }

    public static CollectionPointMaterialResponseDto toResponseDto(CollectionPointMaterial entity) {
        return new CollectionPointMaterialResponseDto(
                entity.getId(),
                EletronicWasteMapper.toResponseDto(entity.getEletronicWaste()),
                entity.getMaxCapacity()
        );
    }

    public static List<CollectionPointMaterialResponseDto> toResponseDtos(List<CollectionPointMaterial> entities) {
        return entities.stream().map(CollectionPointMaterialMapper::toResponseDto).toList();
    }
}
