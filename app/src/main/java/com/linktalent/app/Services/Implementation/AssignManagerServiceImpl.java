package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignManager.AssignManagerDtoRequest;
import com.linktalent.app.Model.Dto.AssignManager.AssignManagerDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import com.linktalent.app.Model.Entity.AssignManager;
import com.linktalent.app.Repository.AssignManagerRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Services.Spec.AssignManagerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignManagerServiceImpl implements AssignManagerService {
    private final AssignManagerRepository assignManagerRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssignManagerDtoResponse> getAll(Pageable pageable) {
        Page<AssignManager> assignManagerPage = assignManagerRepository.findAll(pageable);
        return assignManagerPage.map(assignManager -> modelMapper.map(assignManager, AssignManagerDtoResponse.class));
    }

    @Override
    public Optional<AssignManagerDtoResponse> create(AssignManagerDtoRequest request) {
        AssignManager assignManager = modelMapper.map(request, AssignManager.class);
        EmbeddedAssignManager embeddedAssignManager = new EmbeddedAssignManager();
        embeddedAssignManager.setPlayer(personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found")));
        embeddedAssignManager.setManager(personRepository.findById(request.getId().getManager().getId()).orElseThrow(() -> new ResourceNotFoundException("Manager Not Found")));
        embeddedAssignManager.setAssignDate(LocalDateTime.now());
        assignManager.setId(embeddedAssignManager);
        assignManagerRepository.save(assignManager);
        return Optional.of(modelMapper.map(assignManager, AssignManagerDtoResponse.class));
    }

    @Override
    public Optional<AssignManagerDtoResponse> update(AssignManagerDtoRequest request) {
        Optional<AssignManager> assignManagerToUpdate = assignManagerRepository.findById(request.getId());
        if (assignManagerToUpdate.isPresent()) {
            AssignManager assignManager = assignManagerToUpdate.get();
            EmbeddedAssignManager embeddedAssignManager = assignManager.getId();
            embeddedAssignManager.setPlayer(personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found")));
            embeddedAssignManager.setManager(personRepository.findById(request.getId().getManager().getId()).orElseThrow(() -> new ResourceNotFoundException("Manager Not Found")));
            assignManagerRepository.save(assignManager);
            return Optional.of(modelMapper.map(assignManager, AssignManagerDtoResponse.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignManagerDtoResponse> getById(EmbeddedAssignManager embeddedAssignManager) {
        Optional<AssignManager> assignManager = assignManagerRepository.findById(embeddedAssignManager);
        return assignManager.map(value -> modelMapper.map(value, AssignManagerDtoResponse.class));
    }

    @Override
    public Boolean delete(AssignManagerDtoRequest request) {
        if (assignManagerRepository.existsById(request.getId())) {
            assignManagerRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}

