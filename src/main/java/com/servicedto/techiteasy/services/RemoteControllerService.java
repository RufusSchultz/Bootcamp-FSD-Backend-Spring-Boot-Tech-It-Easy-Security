package com.servicedto.techiteasy.services;

import com.servicedto.techiteasy.dtos.inputs.RemoteControllerInputDto;
import com.servicedto.techiteasy.dtos.mappers.RemoteControllerMapper;
import com.servicedto.techiteasy.dtos.outputs.RemoteControllerOutputDto;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.models.RemoteController;
import com.servicedto.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository repo;

    public RemoteControllerService(RemoteControllerRepository repo) {
        this.repo = repo;
    }

    public List<RemoteController> getAllRemoteControllers() {
        return this.repo.findAll();
    }

    public RemoteControllerOutputDto getRemoteControllerById(Long id) {
        RemoteController rc = this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException("No remote controller with id " + id + " in list."));
        return RemoteControllerMapper.fromRemoteControllerToRemoteControllerOutputDto(rc);
    }

    public RemoteControllerOutputDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc = this.repo.save(RemoteControllerMapper.fromRemoteControllerInputDtoToRemoteController(remoteControllerInputDto));
        return RemoteControllerMapper.fromRemoteControllerToRemoteControllerOutputDto(rc);
    }

    public void deleteRemoteController(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No remote controller in list with id " + id + "!");
        }
    }

    public RemoteControllerOutputDto updateRemoteController (Long id, RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc1 = this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException("No remote controller in list with id " + id + "!"));
        RemoteController rc2 = RemoteControllerMapper.fromRemoteControllerInputDtoToRemoteController(remoteControllerInputDto);

        return RemoteControllerMapper.fromRemoteControllerToRemoteControllerOutputDto(this.repo.save(RemoteControllerMapper.fromRemoteControllerToUpdatedRemoteController(rc1, rc2)));
    }
}
