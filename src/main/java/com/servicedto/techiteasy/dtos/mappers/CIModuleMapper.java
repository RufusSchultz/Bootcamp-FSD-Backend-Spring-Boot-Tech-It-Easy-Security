package com.servicedto.techiteasy.dtos.mappers;


import com.servicedto.techiteasy.dtos.inputs.CIModuleInputDto;
import com.servicedto.techiteasy.dtos.outputs.CIModuleOutputDto;
import com.servicedto.techiteasy.models.CIModule;

public class CIModuleMapper {

    public static CIModule fromCIModuleInputDtoToCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule cim = new CIModule();

        cim.setName(ciModuleInputDto.name);
        cim.setType(ciModuleInputDto.type);
        cim.setPrice(ciModuleInputDto.price);

        return cim;
    }

    public static CIModuleOutputDto fromCIModuleToCIModuleOutputDto(CIModule ciModule) {
        CIModuleOutputDto dto = new CIModuleOutputDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());
        dto.setTelevision(ciModule.getTelevision());

        return dto;
    }

    public static CIModule fromCIModuleToUpdatedCIModule (CIModule cim, CIModule cimUpdateInfo) {

        cim.setName(cimUpdateInfo.getName());
        cim.setType(cimUpdateInfo.getType());
        cim.setPrice(cimUpdateInfo.getPrice());

        return cim;
    }
}

