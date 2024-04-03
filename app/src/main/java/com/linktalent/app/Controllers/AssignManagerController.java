package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignManager.AssignManagerDtoRequest;
import com.linktalent.app.Model.Dto.AssignManager.AssignManagerDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import com.linktalent.app.Services.PersonService;
import com.linktalent.app.Services.Spec.AssignManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/assign-manager")
@RequiredArgsConstructor
public class AssignManagerController {
    private final AssignManagerService assignManagerService;
    private final PersonService personService;

    @GetMapping
    public Page<AssignManagerDtoResponse> getAllAssignManagers(Pageable pageable) {
        return assignManagerService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<AssignManagerDtoResponse> createAssignManager(@Valid @RequestBody AssignManagerDtoRequest request) {
        Optional<AssignManagerDtoResponse> assignManagerDtoResponse = assignManagerService.create(request);
        return assignManagerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create AssignManager"));
    }

    @PutMapping
    public ResponseEntity<AssignManagerDtoResponse> updateAssignManager(@Valid @RequestBody AssignManagerDtoRequest request) {
        Optional<AssignManagerDtoResponse> assignManagerDtoResponse = assignManagerService.update(request);
        return assignManagerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to update AssignManager"));
    }

    @GetMapping("/{playerId}/{managerId}")
    public ResponseEntity<AssignManagerDtoResponse> getAssignManagerById(@PathVariable Integer playerId, @PathVariable Integer managerId) {
        EmbeddedAssignManager embeddedAssignManager = new EmbeddedAssignManager();
        Optional<AssignManagerDtoResponse> assignManagerDtoResponse = assignManagerService.getById(embeddedAssignManager);
        return assignManagerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("AssignManager not found"));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAssignManager(@Valid @RequestBody AssignManagerDtoRequest request) {
        Boolean isDeleted = assignManagerService.delete(request);
        return ResponseEntity.ok(isDeleted);
    }
}
