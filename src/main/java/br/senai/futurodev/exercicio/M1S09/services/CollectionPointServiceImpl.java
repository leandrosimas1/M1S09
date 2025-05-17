package br.senai.futurodev.exercicio.M1S09.services;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointMaterialRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.CollectionPointResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.CollectionPoint;
import br.senai.futurodev.exercicio.M1S09.entities.CollectionPointMaterial;
import br.senai.futurodev.exercicio.M1S09.repositories.CollectionPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CollectionPointServiceImpl implements CollectionPointService {

    private final CollectionPointRepository repository;
    private final ElectronicWasteService electronicWasteService;

    @Override
    public List<CollectionPointResponseDto> findAll() {
        List<CollectionPoint> entities = repository.findAll();
        return CollectionPointMapper.toResponseDtos(entities);
    }

    @Override
    public CollectionPointResponseDto findById(Long id) {
        CollectionPoint entity = findEntityById(id);
        return CollectionPointMapper.toResponseDto(entity);
    }

    @Override
    public CollectionPointResponseDto create(CollectionPointRequestDto dto) {
        return save(new CollectionPoint(), dto);
    }

    @Override
    public CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto) {
        CollectionPoint cp = findEntityById(id);
        return save(cp, dto);
    }

    @Override
    public void delete(Long id) {
        CollectionPoint cp = findEntityById(id);
        repository.delete(cp);
    }

    private CollectionPoint findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CollectionPointNotFoundException(id));
    }

    private CollectionPointResponseDto save(CollectionPoint cp, CollectionPointRequestDto dto) {
        CollectionPointMapper.toEntity(cp, dto);

        for (CollectionPointMaterialRequestDto materialDto : dto.materials()) {
            CollectionPointMaterial material = new CollectionPointMaterial();
            material.setCollectionPoint(cp);
            material.setMaxCapacity(materialDto.maxCapacity());

            ElectronicWaste ew = electronicWasteService.findEntityById(materialDto.electronicWasteId());
            material.setElectronicWaste(ew);

            cp.getMaterials().add(material);
        }

        return CollectionPointMapper.toResponseDto(repository.save(cp));
    }
}