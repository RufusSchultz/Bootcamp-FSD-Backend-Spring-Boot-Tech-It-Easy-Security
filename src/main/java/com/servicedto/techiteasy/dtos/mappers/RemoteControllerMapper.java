package com.servicedto.techiteasy.dtos.mappers;

import com.servicedto.techiteasy.dtos.inputs.RemoteControllerInputDto;
import com.servicedto.techiteasy.dtos.outputs.RemoteControllerOutputDto;
import com.servicedto.techiteasy.models.RemoteController;

public class RemoteControllerMapper {

    public static RemoteController fromRemoteControllerInputDtoToRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc = new RemoteController();

        rc.setCompatibleWith(remoteControllerInputDto.compatibleWith);
        rc.setBatteryType(remoteControllerInputDto.batteryType);
        rc.setName(remoteControllerInputDto.name);
        rc.setBrand(remoteControllerInputDto.brand);
        rc.setPrice(remoteControllerInputDto.price);
        rc.setOriginalStock(remoteControllerInputDto.originalStock);

        return rc;
    }

    public static RemoteControllerOutputDto fromRemoteControllerToRemoteControllerOutputDto (RemoteController remoteController) {
        RemoteControllerOutputDto dto = new RemoteControllerOutputDto();

        dto.setId(remoteController.getId());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        dto.setOriginalStock(remoteController.getOriginalStock());

        return dto;
    }

    public static RemoteController fromRemoteControllerToUpdatedRemoteController (RemoteController rc, RemoteController rcUpdateInfo) {
        rc.setCompatibleWith(rcUpdateInfo.getCompatibleWith());
        rc.setBatteryType(rcUpdateInfo.getBatteryType());
        rc.setName(rcUpdateInfo.getName());
        rc.setBrand(rcUpdateInfo.getBrand());
        rc.setPrice(rcUpdateInfo.getPrice());
        rc.setOriginalStock(rcUpdateInfo.getOriginalStock());

        return rc;
    }
}
