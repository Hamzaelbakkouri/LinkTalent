package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignChat.AssignChatDtoRequest;
import com.linktalent.app.Model.Dto.AssignChat.AssignChatDtoResponse;
import com.linktalent.app.Services.Spec.AssignChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/assign-chat")
@RequiredArgsConstructor
public class AssignChatController {
    private final AssignChatService assignChatService;

    @GetMapping
    public Page<AssignChatDtoResponse> getAllAssignChats(Pageable pageable) {
        return assignChatService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<AssignChatDtoResponse> createAssignChat(@Valid @RequestBody AssignChatDtoRequest request) {
        Optional<AssignChatDtoResponse> assignChatDtoResponse = assignChatService.create(request);
        return assignChatDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create AssignChat"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignChatDtoResponse> updateAssignChat(@PathVariable Integer id, @Valid @RequestBody AssignChatDtoRequest request) {
        request.setId(id);
        Optional<AssignChatDtoResponse> assignChatDtoResponse = assignChatService.update(request);
        return assignChatDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("AssignChat with id " + id + " not found"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignChatDtoResponse> getAssignChatById(@PathVariable Integer id) {
        Optional<AssignChatDtoResponse> assignChatDtoResponse = assignChatService.getById(id);
        return assignChatDtoResponse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("AssignChat with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAssignChat(@PathVariable Integer id) {
        AssignChatDtoRequest request = new AssignChatDtoRequest();
        request.setId(id);
        Boolean isDeleted = assignChatService.delete(request);
        return ResponseEntity.ok(isDeleted);
    }
}