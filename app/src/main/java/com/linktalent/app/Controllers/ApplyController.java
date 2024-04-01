package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoRequest;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Dto.Embeddeds.EmbeddedApplyDTO;
import com.linktalent.app.Model.Dto.Person.ProfileDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Services.Spec.ApplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/apply")
@RequiredArgsConstructor
@Validated
public class ApplyController {
    private final ApplyService applyService;
    private final ModelMapper modelMapper;

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

    @PutMapping("/{announcementId}/{playerId}")
    public ResponseEntity<ApplyDtoResponse> updateApplication(@PathVariable UUID announcementId, @PathVariable UUID playerId, @Valid @RequestBody ApplyDtoRequest request, @PathVariable LocalDate dateTime) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        request.getId().setAnnouncement(modelMapper.map(announcement, AnnouncementRequestDto.class));
        request.getId().setPlayer(modelMapper.map(person, ProfileDtoResponse.class));
        Optional<ApplyDtoResponse> applyResponseDto = applyService.update(request);
        if (applyResponseDto.isPresent()) {
            return ResponseEntity.ok(applyResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Announcement or Player Not Found");
        }
    }

    @GetMapping("/{announcementId}/{playerId}")
    public ResponseEntity<ApplyDtoResponse> getApplicationById(@PathVariable UUID announcementId, @PathVariable UUID playerId) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        EmbeddedApply embeddedApply = new EmbeddedApply();
        embeddedApply.setAnnouncement(announcement);
        embeddedApply.setPlayer(person);
        Optional<ApplyDtoResponse> applyResponseDto = applyService.getById(embeddedApply);
        if (applyResponseDto.isPresent()) {
            return ResponseEntity.ok(applyResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Application Not Found");
        }
    }

    @DeleteMapping("/{announcementId}/{playerId}")
    public ResponseEntity<Boolean> deleteApplication(@PathVariable UUID announcementId, @PathVariable UUID playerId) {
        Announcement announcement = new Announcement();
        Person person = new Person();
        person.setId(playerId);
        announcement.setId(announcementId);
        EmbeddedApply embeddedApply = new EmbeddedApply(announcement, person);
        ApplyDtoRequest request = new ApplyDtoRequest();
        request.getId().setAnnouncement(modelMapper.map(announcement, AnnouncementRequestDto.class));
        request.getId().setPlayer(modelMapper.map(person, ProfileDtoResponse.class));
        boolean deleted = applyService.delete(request);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Page<ApplyDtoResponse>> getUserApplications(Pageable pageable, @PathVariable UUID id) {
        return ResponseEntity.ok(this.applyService.getUserApplication(id, pageable));
    }
}