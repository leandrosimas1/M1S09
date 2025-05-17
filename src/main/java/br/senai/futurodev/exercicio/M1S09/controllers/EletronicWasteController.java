package br.senai.futurodev.exercicio.M1S09.controllers;

import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteRequestDto;
import br.senai.futurodev.exercicio.M1S09.Dtos.eletronicwastes.EletronicWasteResponseDto;
import br.senai.futurodev.exercicio.M1S09.entities.EletronicWaste;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("eletronic_wastes")
public class EletronicWasteController {

    private final EletronicWasteService service;

    @GetMapping
    public List<EletronicWasteResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public EletronicWasteResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public public EletronicWasteResponseDto save(@RequestBody EletronicWasteRequestDto dto){
        return service.create(dto);
    }

    @PutMapping("{id}")
    public public EletronicWasteResponseDto update(@PathVariable Long id, @RequestBody EletronicWasteRequestDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}


