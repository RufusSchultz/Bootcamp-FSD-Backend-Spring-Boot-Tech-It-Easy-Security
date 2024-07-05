package com.servicedto.techiteasy.services;

import com.servicedto.techiteasy.dtos.inputs.CIModuleInputDto;
import com.servicedto.techiteasy.dtos.mappers.CIModuleMapper;
import com.servicedto.techiteasy.dtos.outputs.CIModuleOutputDto;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.models.CIModule;
import com.servicedto.techiteasy.models.Television;
import com.servicedto.techiteasy.repositories.CIModuleRepository;
import com.servicedto.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;
    private final TelevisionRepository televisionRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository, TelevisionRepository televisionRepository) {
        this.ciModuleRepository = ciModuleRepository;
        this.televisionRepository = televisionRepository;
    }

    public List<CIModuleOutputDto> getAllCIModules() {
        List<CIModuleOutputDto> list = new ArrayList<>();
        for (CIModule i: this.ciModuleRepository.findAll()) {
            list.add(CIModuleMapper.fromCIModuleToCIModuleOutputDto(i));
        }
        return list;

    }

    public CIModuleOutputDto getCIModuleById(Long id) {
        CIModule cim = this.ciModuleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No CI-Module with id " + id + " in list."));
        return CIModuleMapper.fromCIModuleToCIModuleOutputDto(cim);
    }

    public CIModuleOutputDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule cim = this.ciModuleRepository.save(CIModuleMapper.fromCIModuleInputDtoToCIModule(ciModuleInputDto));
        return CIModuleMapper.fromCIModuleToCIModuleOutputDto(cim);
    }

    public void deleteCIModule(Long id) {
        if (ciModuleRepository.findById(id).isPresent()) {
            ciModuleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No CI-Module in list with id " + id + "!");
        }
    }

    public CIModuleOutputDto updateCIModule (Long id, CIModuleInputDto ciModuleInputDto) {
        CIModule cim1 = this.ciModuleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No CI-Module in list with id " + id + "!"));
        CIModule cim2 = CIModuleMapper.fromCIModuleInputDtoToCIModule(ciModuleInputDto);

        return CIModuleMapper.fromCIModuleToCIModuleOutputDto(this.ciModuleRepository.save(CIModuleMapper.fromCIModuleToUpdatedCIModule(cim1, cim2)));
    }

    public void assignTelevisionToCIModule (Long ciModuleId, Long televisionId) {
        CIModule ciModule = this.ciModuleRepository.findById(ciModuleId).orElseThrow(() -> new RecordNotFoundException("No CI-Module with id " + ciModuleId + " in list."));
        Television television = this.televisionRepository.findById(televisionId).orElseThrow(() -> new RecordNotFoundException("No television with id " + televisionId + " in list."));

        ciModule.setTelevision(television);
        this.ciModuleRepository.save(ciModule);
    }
}
