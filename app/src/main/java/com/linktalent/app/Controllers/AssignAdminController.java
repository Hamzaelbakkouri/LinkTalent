package com.linktalent.app.Controllers;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoRequest;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignAdmin;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Services.Spec.AssignAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/assignAdmin")
@RequiredArgsConstructor
public class AssignAdminController {

    private final AssignAdminService assignAdminService;

    @GetMapping
    public Page<AssignAdminDtoResponse> getAllAssignAdmins(Pageable pageable) {
        return assignAdminService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<AssignAdminDtoResponse> createAssignAdmin(@Valid @RequestBody AssignAdminDtoRequest request) {
        Optional<AssignAdminDtoResponse> assignAdminResponseDto = assignAdminService.create(request);
        if (assignAdminResponseDto.isPresent()) {
            return ResponseEntity.ok(assignAdminResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Team or Team Admin Not Found");
        }
    }

    @PutMapping("/{teamId}/{teamAdminId}")
    public ResponseEntity<AssignAdminDtoResponse> updateAssignAdmin(@PathVariable UUID teamId, @PathVariable UUID teamAdminId, @Valid @RequestBody AssignAdminDtoRequest request) {
        new Team();
        request.getId().setTeam(Team.builder().id(teamId).build());
        request.getId().setTeamAdmin(Person.builder().id(teamAdminId).build());
        Optional<AssignAdminDtoResponse> assignAdminResponseDto = assignAdminService.update(request);
        if (assignAdminResponseDto.isPresent()) {
            return ResponseEntity.ok(assignAdminResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Team or Team Admin Not Found");
        }
    }

    @GetMapping("/{teamId}/{teamAdminId}")
    public ResponseEntity<AssignAdminDtoResponse> getAssignAdminById(@PathVariable UUID teamId, @PathVariable UUID teamAdminId) {
        Team team = new Team();
        team.setId(teamId);
        Person admin = new Person();
        admin.setId(teamAdminId);
        EmbeddedAssignAdmin embeddedAssignAdmin = new EmbeddedAssignAdmin();
        embeddedAssignAdmin.setTeam(team);
        embeddedAssignAdmin.setTeamAdmin(admin);
        Optional<AssignAdminDtoResponse> assignAdminResponseDto = assignAdminService.getById(embeddedAssignAdmin);
        if (assignAdminResponseDto.isPresent()) {
            return ResponseEntity.ok(assignAdminResponseDto.get());
        } else {
            throw new ResourceNotFoundException("Assign Admin Not Found");
        }
    }

    @DeleteMapping("/{teamId}/{teamAdminId}")
    public ResponseEntity<Boolean> deleteAssignAdmin(@PathVariable UUID teamId, @PathVariable UUID teamAdminId) {
        Team team = new Team();
        team.setId(teamId);
        Person admin = new Person();
        admin.setId(teamAdminId);
        EmbeddedAssignAdmin embeddedAssignAdmin = new EmbeddedAssignAdmin();
        embeddedAssignAdmin.setTeam(team);
        embeddedAssignAdmin.setTeamAdmin(admin);
        AssignAdminDtoRequest request = new AssignAdminDtoRequest();
        request.setId(embeddedAssignAdmin);
        boolean deleted = assignAdminService.delete(request);
        return ResponseEntity.ok(deleted);
    }
}
