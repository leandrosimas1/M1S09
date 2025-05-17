package br.senai.futurodev.exercicio.M1S09.mappers;

import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.EletronicWaste;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class EletronicWasteMapper {

    private EletronicWasteMapper(){}


    public static EletronicWaste toEntity(EletronicWaste entity, EletronicWasteRequestDto dto) {
        entity.setType(dto.type());
        entity.setDescription(dto.description());
        return entity;

    }

    public static EletronicWasteResponseDto toResponseDto(EletronicWaste entity){
        return new EletronicWasteResponseDto(
                entity.getId(),
                entity.getType(),
                entity.getDescription());
    }

    public static List<EletronicWasteResponseDto> toResponseDtos(List<EletronicWaste> entities){
        return entities.stream().map(EletronicWasteMapper::toResponseDto).toList();
    }
}
