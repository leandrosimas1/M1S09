package br.senai.futurodev.exercicio.M1S09.mappers;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointMaterialResponseDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.CollectionPoint;

import java.util.List;

public class CollectionPointMapper {

    private CollectionPointMapper(){}

    private static CollectionPoint toEntity(CollectionPoint entity, CollectionPointRequestDto dto){
        entity.setName(dto.name());
        entity.setAddress(dto.address());
        entity.setCollectionPeriod(dto.collectionPeriod());
        return entity;
    }

    public static CollectionPointResponseDto toResponseDto(CollectionPoint entity){
        return new CollectionPointResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCollectionPeriod(),
                CollectionPointMaterialMapper.toResponseDtos(entity.getMaterials())
        );
    }

    public static List<CollectionPointResponseDto> toResponseDtos(List<CollectionPoint> entities){
        return entities.stream().map(CollectionPointMapper::toResponseDto).toList();
    }
}
