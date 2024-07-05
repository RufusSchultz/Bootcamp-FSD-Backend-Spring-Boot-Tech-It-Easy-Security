package com.servicedto.techiteasy.controllers;

import com.servicedto.techiteasy.dtos.inputs.CIModuleInputDto;
import com.servicedto.techiteasy.dtos.outputs.CIModuleOutputDto;
import com.servicedto.techiteasy.models.CIModule;
import com.servicedto.techiteasy.services.CIModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.servicedto.techiteasy.helpers.ValidationChecker.validationCheckToNullOrResponse;

@RestController
@RequestMapping("/ci-modules")
public class CIModuleController {
    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CIModuleOutputDto>> getAllCIModules() {
        return ResponseEntity.ok(service.getAllCIModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleOutputDto> getCIModule(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCIModuleById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCIModule(@Valid @RequestBody CIModuleInputDto ciModuleInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                CIModuleOutputDto ciModuleOutputDto = service.createCIModule(ciModuleInputDto);
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + ciModuleOutputDto.getId()).toUriString());
                return ResponseEntity.created(uri).body(ciModuleOutputDto);
            } else {
                return validationCheckToNullOrResponse(br);
            }
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to create CI-Module");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCIModule(@PathVariable Long id) {
        service.deleteCIModule(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCIModule(@Valid @PathVariable Long id, @RequestBody CIModuleInputDto ciModuleInputDto, BindingResult br) {
        try {
            if (validationCheckToNullOrResponse(br) == null) {
                CIModuleOutputDto ciModuleOutputDto = service.updateCIModule(id, ciModuleInputDto);
                return ResponseEntity.ok("Updated CI-Module " + id + ".");
            } else {
                return validationCheckToNullOrResponse(br);
            }

        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body("Failed to update CI-Module");
        }

    }

    @PostMapping("/{ciModuleId}/assign-television")
    public ResponseEntity<?> assignTelevision(@PathVariable Long ciModuleId, @RequestParam Long televisionId) {
        this.service.assignTelevisionToCIModule(ciModuleId, televisionId);

        return ResponseEntity.ok("Television " + televisionId + " assigned to CI-Module " + ciModuleId + ".");
    }
}
