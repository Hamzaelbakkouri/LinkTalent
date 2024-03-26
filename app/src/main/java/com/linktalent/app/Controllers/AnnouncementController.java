package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementResponseDto;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Services.Spec.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/announcement")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping
    public Page<AnnouncementResponseDto> getAllAnnouncements(Pageable pageable) {
        return announcementService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<AnnouncementResponseDto> createAnnouncement(@Valid @RequestBody AnnouncementRequestDto request) {
        Optional<AnnouncementResponseDto> announcementResponseDto = announcementService.create(request);
        if (announcementResponseDto.isPresent()) {
            return ResponseEntity.ok(announcementResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Team with Id: " + request.getTeam() + " Not Found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementResponseDto> updateAnnouncement(@PathVariable UUID id, @Valid @RequestBody AnnouncementRequestDto request) {
        Optional<AnnouncementResponseDto> announcementResponseDto = announcementService.update(request);
        if (announcementResponseDto.isPresent()) {
            return ResponseEntity.ok(announcementResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Announcement with Id: " + id + " Not Found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementResponseDto> getAnnouncementById(@PathVariable UUID id) {
        Optional<AnnouncementResponseDto> announcementResponseDto = announcementService.getById(id);
        if (announcementResponseDto.isPresent()) {
            return ResponseEntity.ok(announcementResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Announcement with Id: " + id + " Not Found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAnnouncement(@PathVariable UUID id) {
        AnnouncementRequestDto announcementRequestDto = new AnnouncementRequestDto();
        announcementRequestDto.setId(id);
        announcementService.delete(announcementRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/team/{teamId}")
    public Page<AnnouncementResponseDto> getAnnouncementsByTeam(@PathVariable UUID teamId, Pageable pageable) {
        Team team = new Team();
        team.setId(teamId);
        return announcementService.findAllByTeam(team, pageable);
    }
}
