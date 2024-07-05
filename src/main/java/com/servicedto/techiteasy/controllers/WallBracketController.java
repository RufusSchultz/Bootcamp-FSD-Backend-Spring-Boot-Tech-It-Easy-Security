package com.servicedto.techiteasy.controllers;

import com.servicedto.techiteasy.dtos.inputs.WallBracketInputDto;
import com.servicedto.techiteasy.dtos.outputs.WallBracketOutputDto;
import com.servicedto.techiteasy.models.WallBracket;
import com.servicedto.techiteasy.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.servicedto.techiteasy.helpers.ValidationChecker.validationCheckToNullOrResponse;

@RestController
@RequestMapping("/wall-brackets")
public class WallBracketController {
    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WallBracket>> getAllWallBrackets() {
        return ResponseEntity.ok(service.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(service.getWallBracketById(id));
    }

    @PostMapping
    public ResponseEntity<?> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                WallBracketOutputDto wallBracketOutputDto = service.createWallBracket(wallBracketInputDto);
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + wallBracketOutputDto.getId()).toUriString());
                return ResponseEntity.created(uri).body(wallBracketOutputDto);
            } else {
                return validationCheckToNullOrResponse(br);
            }
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to create wall bracket");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
        service.deleteWallBracket(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWallBracket(@Valid @PathVariable Long id, @RequestBody WallBracketInputDto wallBracketInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                WallBracketOutputDto wallBracketOutputDto = service.updateWallBracket(id, wallBracketInputDto);
                return ResponseEntity.ok("Updated wall bracket " + id + ".");
            } else {
                return validationCheckToNullOrResponse(br);
            }

        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to update wall bracket");
        }

    }

}
