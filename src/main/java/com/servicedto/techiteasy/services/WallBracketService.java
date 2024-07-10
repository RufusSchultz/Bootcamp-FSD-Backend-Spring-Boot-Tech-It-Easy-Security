package com.servicedto.techiteasy.services;

import com.servicedto.techiteasy.dtos.inputs.WallBracketInputDto;
import com.servicedto.techiteasy.dtos.mappers.WallBracketMapper;
import com.servicedto.techiteasy.dtos.outputs.WallBracketOutputDto;
import com.servicedto.techiteasy.exceptions.RecordNotFoundException;
import com.servicedto.techiteasy.models.WallBracket;
import com.servicedto.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository repo;

    public WallBracketService(WallBracketRepository repo) {
        this.repo = repo;
    }

    public List<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracketOutputDto> list = new ArrayList<>();
        for (WallBracket i: this.repo.findAll()) {
            list.add(WallBracketMapper.fromWallBracketToWallBracketOutputDto(i));
        }
        return list;
    }

    public WallBracketOutputDto getWallBracketById(Long id) {
        WallBracket wb = this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException("No wall bracket with id " + id + " in list."));
        return WallBracketMapper.fromWallBracketToWallBracketOutputDto(wb);
    }

    public WallBracketOutputDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = this.repo.save(WallBracketMapper.fromWallBracketInputDtoToWallBracket(wallBracketInputDto));
        return WallBracketMapper.fromWallBracketToWallBracketOutputDto(wb);
    }

    public void deleteWallBracket(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No wall bracket in list with id " + id + "!");
        }
    }

    public WallBracketOutputDto updateWallBracket (Long id, WallBracketInputDto wallBracketInputDto) {
        WallBracket wb1 = this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException("No wall bracket in list with id " + id + "!"));
        WallBracket wb2 = WallBracketMapper.fromWallBracketInputDtoToWallBracket(wallBracketInputDto);

        return WallBracketMapper.fromWallBracketToWallBracketOutputDto(this.repo.save(WallBracketMapper.fromWallBracketToUpdatedWallBracket(wb1, wb2)));
    }
}
