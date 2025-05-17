package br.senai.futurodev.exercicio.M1S09.services;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.EletronicWastRequestDto;

import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteResponseDto;

import java.util.List;

public interface EletronicWasteService {

    List<EletronicWasteResponseDto> findAll();
    EletronicWasteResponseDto findById(Long id);
    EletronicWasteResponseDto create(EletronicWasteRequestDto dto);
    EletronicWasteResponseDto update(Long id, EletronicWasteRequestDto dto);
    void delete(Long id);
}
