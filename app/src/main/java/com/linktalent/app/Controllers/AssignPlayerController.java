package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoRequest;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Repository.TeamRepository;
import com.linktalent.app.Services.Spec.AssignPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/assign-player")
@RequiredArgsConstructor
public class AssignPlayerController {
    private final AssignPlayerService assignPlayerService;

    @GetMapping
    public Page<AssignPlayerDtoResponse> getAllAssignPlayers(Pageable pageable) {
        return assignPlayerService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<AssignPlayerDtoResponse> createAssignPlayer(@Valid @RequestBody AssignPlayerDtoRequest request) {
        Optional<AssignPlayerDtoResponse> assignPlayerDtoResponse = assignPlayerService.create(request);
        return assignPlayerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create AssignPlayer"));
    }

    @PutMapping
    public ResponseEntity<AssignPlayerDtoResponse> updateAssignPlayer(@Valid @RequestBody AssignPlayerDtoRequest request) {
        Optional<AssignPlayerDtoResponse> assignPlayerDtoResponse = assignPlayerService.update(request);
        return assignPlayerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to update AssignPlayer"));
    }


    @GetMapping("/{playerId}/{teamId}")
    public ResponseEntity<AssignPlayerDtoResponse> getAssignPlayerById(@PathVariable Integer playerId, @PathVariable Integer teamId) {
        EmbeddedAssignPlayer embeddedAssignPlayer = new EmbeddedAssignPlayer();
        Optional<AssignPlayerDtoResponse> assignPlayerDtoResponse = assignPlayerService.getById(embeddedAssignPlayer);
        return assignPlayerDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("AssignPlayer not found"));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAssignPlayer(@Valid @RequestBody AssignPlayerDtoRequest request) {
        Boolean isDeleted = assignPlayerService.delete(request);
        return ResponseEntity.ok(isDeleted);
    }
}