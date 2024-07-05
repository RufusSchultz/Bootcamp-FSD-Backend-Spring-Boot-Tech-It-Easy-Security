package com.servicedto.techiteasy.services;

import com.servicedto.techiteasy.dtos.inputs.TelevisionInputDto;
import com.servicedto.techiteasy.dtos.mappers.TelevisionMapper;
import com.servicedto.techiteasy.dtos.outputs.TelevisionOutputDto;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.models.RemoteController;
import com.servicedto.techiteasy.models.Television;
import com.servicedto.techiteasy.models.WallBracket;
import com.servicedto.techiteasy.repositories.RemoteControllerRepository;
import com.servicedto.techiteasy.repositories.TelevisionRepository;
import com.servicedto.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<Television> getAllTelevisions() {
        return this.televisionRepository.findAll();
    }

    public TelevisionOutputDto getTelevisionById(Long id) {
        Television t = this.televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No television with id " + id + " in list."));
        return TelevisionMapper.fromTelevisionToTelevisionOutputDto(t);
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = this.televisionRepository.save(TelevisionMapper.fromTelevisionInputDtoToTelevision(televisionInputDto));
        return TelevisionMapper.fromTelevisionToTelevisionOutputDto(t);
    }

    public void deleteTelevision(Long id) {
        if (this.televisionRepository.findById(id).isPresent()) {
            this.televisionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No television in list with id " + id + "!");
        }
    }

    public TelevisionOutputDto updateTelevision (Long id, TelevisionInputDto televisionInputDto) {
        Television t1 = this.televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No television in list with id " + id + "!"));
        Television t2 = TelevisionMapper.fromTelevisionInputDtoToTelevision(televisionInputDto);

        return TelevisionMapper.fromTelevisionToTelevisionOutputDto(this.televisionRepository.save(TelevisionMapper.fromTelevisionToUpdatedTelevision(t1, t2)));
    }

    public void assignRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Television television = this.televisionRepository.findById(televisionId).orElseThrow(() -> new RecordNotFoundException("No television with id " + televisionId + " in list."));
        RemoteController remoteController = this.remoteControllerRepository.findById(remoteControllerId).orElseThrow(() -> new RecordNotFoundException("No remote control with id " + remoteControllerId + " in list."));

        television.setRemoteController(remoteController);
        this.televisionRepository.save(television);
    }

    public void assignWallBracketToTelevision(Long televisionId, Long wallBracketId) {
        Television television = this.televisionRepository.findById(televisionId).orElseThrow(() -> new RecordNotFoundException("No television with id " + televisionId + " in list."));
        WallBracket wallBracket = this.wallBracketRepository.findById(wallBracketId).orElseThrow(() -> new RecordNotFoundException("No wall bracket with id " + wallBracketId + " in list."));

        television.getWallBrackets().add(wallBracket);
        this.televisionRepository.save(television);
    }
}
