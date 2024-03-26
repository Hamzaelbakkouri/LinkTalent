package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoRequest;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Services.Spec.ApplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/apply")
@RequiredArgsConstructor
public class ApplyController {
    private final ApplyService applyService;

    @GetMapping
    public Page<ApplyDtoResponse> getAllApplications(Pageable pageable) {
        return applyService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<ApplyDtoResponse> createApplication(@Valid @RequestBody ApplyDtoRequest request) {
        Optional<ApplyDtoResponse> applyResponseDto = applyService.create(request);
        if (applyResponseDto.isPresent()) {
            return ResponseEntity.ok(applyResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Announcement or Player Not Found");
        }
    }

    @PutMapping("/{announcementId}/{playerId}/{dateTime}")
    public ResponseEntity<ApplyDtoResponse> updateApplication(@PathVariable UUID announcementId, @PathVariable UUID playerId, @Valid @RequestBody ApplyDtoRequest request, @PathVariable LocalDateTime dateTime) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        request.getId().setAnnouncement(announcement);
        request.getId().setPlayer(person);
        request.getId().setApplyingDate(dateTime);
        Optional<ApplyDtoResponse> applyResponseDto = applyService.update(request);
        if (applyResponseDto.isPresent()) {
            return ResponseEntity.ok(applyResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Announcement or Player Not Found");
        }
    }

    @GetMapping("/{announcementId}/{playerId}/{dateTime}")
    public ResponseEntity<ApplyDtoResponse> getApplicationById(@PathVariable UUID announcementId, @PathVariable UUID playerId, @PathVariable LocalDateTime dateTime) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        EmbeddedApply embeddedApply = new EmbeddedApply(announcement, person, dateTime);
        Optional<ApplyDtoResponse> applyResponseDto = applyService.getById(embeddedApply);
        if (applyResponseDto.isPresent()) {
            return ResponseEntity.ok(applyResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Application Not Found");
        }
    }

    @DeleteMapping("/{announcementId}/{playerId}/{dateTime}")
    public ResponseEntity<Boolean> deleteApplication(@PathVariable UUID announcementId, @PathVariable UUID playerId, @PathVariable LocalDateTime dateTime) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        EmbeddedApply embeddedApply = new EmbeddedApply(announcement, person, dateTime);
        ApplyDtoRequest request = new ApplyDtoRequest();
        request.setId(embeddedApply);
        boolean deleted = applyService.delete(request);
        return ResponseEntity.ok(deleted);
    }
}

