package br.senai.futurodev.exercicio.M1S09.services;

import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.EletronicWasteMaterialRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.EletronicWasteRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.collectionpoints.EletronicWasteResponseDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.EletronicWaste;
import br.senai.futurodev.exercicio.M1S09.entities.EletronicWasteMaterial;
import br.senai.futurodev.exercicio.M1S09.repositories.EletronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EletronicWasteServiceImpl implements EletronicWasteService {

    private final EletronicWasteRepository repository;
    private final EletronicWasteService electronicWasteService;

    @Override
    public List<EletronicWasteResponseDto> findAll() {
        List<EletronicWaste> entities = repository.findAll();
        return EletronicWasteMapper.toResponseDtos(entities);
    }

    @Override
    public EletronicWasteResponseDto findById(Long id) {
        EletronicWaste entity = findEntityById(id);
        return EletronicWasteMapper.toResponseDto(entity);
    }

    @Override
    public EletronicWasteResponseDto create(EletronicWasteRequestDto dto) {
        return save(new EletronicWaste(), dto);
    }

    @Override
    public EletronicWasteResponseDto update(Long id, EletronicWasteRequestDto dto) {
        EletronicWaste cp = findEntityById(id);
        return save(cp, dto);
    }

    @Override
    public void delete(Long id) {
        EletronicWaste cp = findEntityById(id);
        repository.delete(cp);
    }

    private EletronicWaste findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EletronicWasteNotFoundException(id));
    }

    private EletronicWasteResponseDto save(EletronicWaste cp, EletronicWasteRequestDto dto) {
        EletronicWasteMapper.toEntity(cp, dto);

        for (EletronicWasteMaterialRequestDto materialDto : dto.materials()) {
            EletronicWasteMaterial material = new EletronicWasteMaterial();
            material.setEletronicWaste(cp);
            material.setMaxCapacity(materialDto.maxCapacity());

            ElectronicWaste ew = electronicWasteService.findEntityById(materialDto.electronicWasteId());
            material.setElectronicWaste(ew);

            cp.getMaterials().add(material);
        }

        return EletronicWasteMapper.toResponseDto(repository.save(cp));
    }
}