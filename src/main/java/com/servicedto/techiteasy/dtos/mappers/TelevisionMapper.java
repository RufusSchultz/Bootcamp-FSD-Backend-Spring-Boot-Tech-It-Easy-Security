package com.servicedto.techiteasy.dtos.mappers;

import com.servicedto.techiteasy.dtos.inputs.TelevisionInputDto;
import com.servicedto.techiteasy.dtos.outputs.TelevisionOutputDto;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.models.Television;

public class TelevisionMapper {

    public static Television fromTelevisionInputDtoToTelevision(TelevisionInputDto televisionInputDto) {
        Television t = new Television();

        t.setType(televisionInputDto.type);
        t.setBrand(televisionInputDto.brand);
        t.setName(televisionInputDto.name);
        t.setPrice(televisionInputDto.price);
        t.setAvailableSize(televisionInputDto.availableSize);
        t.setRefreshRate(televisionInputDto.refreshRate);
        t.setScreenType(televisionInputDto.screenType);
        t.setScreenQuality(televisionInputDto.screenQuality);
        t.setSmartTv(televisionInputDto.smartTv);
        t.setWifi(televisionInputDto.wifi);
        t.setVoiceControl(televisionInputDto.voiceControl);
        t.setHdr(televisionInputDto.hdr);
        t.setBluetooth(televisionInputDto.bluetooth);
        t.setAmbiLight(televisionInputDto.ambiLight);
        t.setOriginalStock(televisionInputDto.originalStock);
        t.setSold(televisionInputDto.sold);

        return t;
    }

    public static TelevisionOutputDto fromTelevisionToTelevisionOutputDto(Television television) {
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();

        televisionOutputDto.setId(television.getId());
        televisionOutputDto.setType(television.getType());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setAvailableSize(television.getAvailableSize());
        televisionOutputDto.setRefreshRate(television.getRefreshRate());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setSmartTv(television.isSmartTv());
        televisionOutputDto.setWifi(television.isWifi());
        televisionOutputDto.setVoiceControl(television.isVoiceControl());
        televisionOutputDto.setHdr(television.isHdr());
        televisionOutputDto.setBluetooth(television.isBluetooth());
        televisionOutputDto.setAmbiLight(television.isAmbiLight());
        televisionOutputDto.setOriginalStock(television.getOriginalStock());
        televisionOutputDto.setSold(television.getSold());
        televisionOutputDto.setRemoteController(television.getRemoteController());
        televisionOutputDto.setWallBrackets(television.getWallBrackets());

        return televisionOutputDto;
    }

    public static Television fromTelevisionToUpdatedTelevision (Television t, Television tUpdateInfo) {

        t.setType(tUpdateInfo.getType());
        t.setBrand(tUpdateInfo.getBrand());
        t.setName(tUpdateInfo.getName());
        t.setPrice(tUpdateInfo.getPrice());
        t.setAvailableSize(tUpdateInfo.getAvailableSize());
        t.setRefreshRate(tUpdateInfo.getRefreshRate());
        t.setScreenType(tUpdateInfo.getScreenType());
        t.setScreenQuality(tUpdateInfo.getScreenQuality());
        t.setSmartTv(tUpdateInfo.isSmartTv());
        t.setWifi(tUpdateInfo.isWifi());
        t.setVoiceControl(tUpdateInfo.isVoiceControl());
        t.setHdr(tUpdateInfo.isHdr());
        t.setBluetooth(tUpdateInfo.isBluetooth());
        t.setAmbiLight(tUpdateInfo.isAmbiLight());
        t.setOriginalStock(tUpdateInfo.getOriginalStock());
        t.setSold(tUpdateInfo.getSold());

        return t;
    }
}
