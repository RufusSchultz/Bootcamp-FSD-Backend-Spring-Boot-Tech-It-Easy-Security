package com.servicedto.techiteasy.controllers;

import com.servicedto.techiteasy.dtos.inputs.RemoteControllerInputDto;
import com.servicedto.techiteasy.dtos.outputs.RemoteControllerOutputDto;
import com.servicedto.techiteasy.models.RemoteController;
import com.servicedto.techiteasy.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.servicedto.techiteasy.helpers.ValidationChecker.validationCheckToNullOrResponse;

@RestController
@RequestMapping("/remote-controllers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RemoteController>> getAllRemoteControllers() {
        return ResponseEntity.ok(service.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRemoteController(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRemoteControllerById(id));
    }

    @PostMapping
    public ResponseEntity<?> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                RemoteControllerOutputDto remoteControllerOutputDto = service.createRemoteController(remoteControllerInputDto);
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + remoteControllerOutputDto.getId()).toUriString());
                return ResponseEntity.created(uri).body(remoteControllerOutputDto);
            } else {
                return validationCheckToNullOrResponse(br);
            }
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to create remote controller");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {
        service.deleteRemoteController(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRemoteController(@Valid @PathVariable Long id, @RequestBody RemoteControllerInputDto remoteControllerInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                RemoteControllerOutputDto remoteControllerOutputDto = service.updateRemoteController(id, remoteControllerInputDto);
                return ResponseEntity.ok("Updated remote controller " + id + ".");
            } else {
                return validationCheckToNullOrResponse(br);
            }

        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to update remote controller");
        }

    }
}
