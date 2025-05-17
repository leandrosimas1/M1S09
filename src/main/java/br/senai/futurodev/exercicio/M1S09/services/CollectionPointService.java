package br.senai.futurodev.exercicio.M1S09.services;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointResponseDto;

import java.util.List;

public interface CollectionPointService {

    List<CollectionPointResponseDto> findAll();
    CollectionPointResponseDto findById(Long id);
    CollectionPointResponseDto create(CollectionPointRequestDto dto);
    CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto);
    void delete(Long id);
}
