package com.servicedto.techiteasy.controllers;

import com.servicedto.techiteasy.dtos.inputs.TelevisionInputDto;
import com.servicedto.techiteasy.dtos.outputs.TelevisionOutputDto;
import com.servicedto.techiteasy.models.Television;
import com.servicedto.techiteasy.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.servicedto.techiteasy.helpers.ValidationChecker.validationCheckToNullOrResponse;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        return ResponseEntity.ok(service.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTelevisionById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                TelevisionOutputDto televisionOutputDto = service.createTelevision(televisionInputDto);
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + televisionOutputDto.getId()).toUriString());
                return ResponseEntity.created(uri).body(televisionOutputDto);
            } else {
                return validationCheckToNullOrResponse(br);
            }
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to create television");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTelevision(@Valid @PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                TelevisionOutputDto televisionOutputDto = service.updateTelevision(id, televisionInputDto);
                return ResponseEntity.ok("Updated television " + id + ".");
            } else {
                return validationCheckToNullOrResponse(br);
            }

        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to update television");
        }

    }

    @PostMapping("/{televisionId}/assign-remote-controller")
    public ResponseEntity<?> assignRemoteController(@PathVariable Long televisionId, @RequestParam Long remoteControllerId) {
        this.service.assignRemoteControllerToTelevision(televisionId, remoteControllerId);

        return ResponseEntity.ok("Remote Controller " + remoteControllerId + " assigned to television " + televisionId + ".");
    }

    @PostMapping("/{televisionId}/assign-wall-bracket")
    public ResponseEntity<?> assignWallBracket(@PathVariable Long televisionId, @RequestParam Long wallBracketId) {
        this.service.assignWallBracketToTelevision(televisionId, wallBracketId);

        return ResponseEntity.ok("Wall bracket " + wallBracketId + " assigned to television " + televisionId + ".");
    }

}
