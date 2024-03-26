package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoRequest;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignAdmin;
import com.linktalent.app.Model.Entity.AssignAdmin;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Repository.AssignAdminRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Repository.TeamRepository;
import com.linktalent.app.Services.Spec.AssignAdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignAdminServiceImpl implements AssignAdminService {
    private final AssignAdminRepository assignAdminRepository;
    private final TeamRepository teamRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssignAdminDtoResponse> getAll(Pageable pageable) {
        Page<AssignAdmin> assignAdminPage = assignAdminRepository.findAll(pageable);
        return assignAdminPage.map(assignAdmin -> modelMapper.map(assignAdmin, AssignAdminDtoResponse.class));
    }

    @Override
    public Optional<AssignAdminDtoResponse> create(AssignAdminDtoRequest request) {
        AssignAdmin assignAdmin = modelMapper.map(request, AssignAdmin.class);
        Team team = teamRepository.findById(request.getId().getTeam().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Not Found"));
        Person teamAdmin = personRepository.findById(request.getId().getTeamAdmin().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Admin Not Found"));
        if (team != null && teamAdmin != null) {
            EmbeddedAssignAdmin embeddedAssignAdmin = new EmbeddedAssignAdmin();
            embeddedAssignAdmin.setTeam(team);
            embeddedAssignAdmin.setTeamAdmin(teamAdmin);
            assignAdmin.getId().setStartLeading(LocalDateTime.now());
            assignAdmin.getId().setTeam(team);
            assignAdmin.getId().setTeamAdmin(teamAdmin);
            assignAdminRepository.save(assignAdmin);
            return Optional.of(modelMapper.map(assignAdmin, AssignAdminDtoResponse.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<AssignAdminDtoResponse> update(AssignAdminDtoRequest request) {
        Optional<AssignAdmin> assignAdminToUpdate = assignAdminRepository.findById(request.getId());
        if (assignAdminToUpdate.isPresent()) {
            AssignAdmin assignAdmin = modelMapper.map(request, AssignAdmin.class);
            Team team = teamRepository.findById(request.getId().getTeam().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Not Found"));
            Person teamAdmin = personRepository.findById(request.getId().getTeamAdmin().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Admin Not Found"));
            if (team != null && teamAdmin != null) {
                assignAdmin.getId().setTeam(team);
                assignAdmin.getId().setTeamAdmin(teamAdmin);
                assignAdminRepository.save(assignAdmin);
                return Optional.of(modelMapper.map(assignAdmin, AssignAdminDtoResponse.class));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignAdminDtoResponse> getById(EmbeddedAssignAdmin embeddedAssignAdmin) {
        Optional<AssignAdmin> assignAdmin = assignAdminRepository.findById(embeddedAssignAdmin);
        return assignAdmin.map(value -> modelMapper.map(value, AssignAdminDtoResponse.class));
    }

    @Override
    public Boolean delete(AssignAdminDtoRequest request) {
        if (assignAdminRepository.findById(request.getId()).isPresent()) {
            assignAdminRepository.deleteById(request.getId());
            return true;
        }
        throw new ResourceNotFoundException("Assign Admin with id : " + request.getId() + " Not Found");
    }
}

