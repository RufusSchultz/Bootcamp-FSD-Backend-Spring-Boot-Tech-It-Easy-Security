package com.servicedto.techiteasy.dtos.mappers;


import com.servicedto.techiteasy.dtos.inputs.WallBracketInputDto;
import com.servicedto.techiteasy.dtos.outputs.WallBracketOutputDto;
import com.servicedto.techiteasy.models.WallBracket;

public class WallBracketMapper {

    public static WallBracket fromWallBracketInputDtoToWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = new WallBracket();

        wb.setSize(wallBracketInputDto.size);
        wb.setName(wallBracketInputDto.name);
        wb.setPrice(wallBracketInputDto.price);

        return wb;
    }

    public static WallBracketOutputDto fromWallBracketToWallBracketOutputDto(WallBracket wallBracket) {
        WallBracketOutputDto dto = new WallBracketOutputDto();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }

    public static WallBracket fromWallBracketToUpdatedWallBracket (WallBracket wb, WallBracket wbUpdateInfo) {
        wb.setSize(wbUpdateInfo.getSize());
        wb.setName(wbUpdateInfo.getName());
        wb.setPrice(wbUpdateInfo.getPrice());

        return wb;
    }
}

