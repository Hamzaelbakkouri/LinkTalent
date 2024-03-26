package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoRequest;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import com.linktalent.app.Model.Entity.AssignPlayer;
import com.linktalent.app.Repository.AssignPlayerRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Repository.TeamRepository;
import com.linktalent.app.Services.Spec.AssignPlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignPlayerServiceImpl implements AssignPlayerService {
    private final AssignPlayerRepository assignPlayerRepository;
    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssignPlayerDtoResponse> getAll(Pageable pageable) {
        Page<AssignPlayer> assignPlayerPage = assignPlayerRepository.findAll(pageable);
        return assignPlayerPage.map(assignPlayer -> modelMapper.map(assignPlayer, AssignPlayerDtoResponse.class));
    }

    @Override
    public Optional<AssignPlayerDtoResponse> create(AssignPlayerDtoRequest request) {
        AssignPlayer assignPlayer = modelMapper.map(request, AssignPlayer.class);
        EmbeddedAssignPlayer embeddedAssignPlayer = new EmbeddedAssignPlayer();
        embeddedAssignPlayer.setPlayer(personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found")));
        embeddedAssignPlayer.setTeam(teamRepository.findById(request.getId().getTeam().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Not Found")));
        embeddedAssignPlayer.setAssigningDate(LocalDateTime.now());
        assignPlayer.setId(embeddedAssignPlayer);
        assignPlayerRepository.save(assignPlayer);
        return Optional.of(modelMapper.map(assignPlayer, AssignPlayerDtoResponse.class));
    }

    @Override
    public Optional<AssignPlayerDtoResponse> update(AssignPlayerDtoRequest request) {
        Optional<AssignPlayer> assignPlayerToUpdate = assignPlayerRepository.findById(request.getId());
        if (assignPlayerToUpdate.isPresent()) {
            AssignPlayer assignPlayer = assignPlayerToUpdate.get();
            EmbeddedAssignPlayer embeddedAssignPlayer = assignPlayer.getId();
            embeddedAssignPlayer.setPlayer(personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found")));
            embeddedAssignPlayer.setTeam(teamRepository.findById(request.getId().getTeam().getId()).orElseThrow(() -> new ResourceNotFoundException("Team Not Found")));
            assignPlayerRepository.save(assignPlayer);
            return Optional.of(modelMapper.map(assignPlayer, AssignPlayerDtoResponse.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignPlayerDtoResponse> getById(EmbeddedAssignPlayer embeddedAssignPlayer) {
        Optional<AssignPlayer> assignPlayer = assignPlayerRepository.findById(embeddedAssignPlayer);
        return assignPlayer.map(value -> modelMapper.map(value, AssignPlayerDtoResponse.class));
    }

    @Override
    public Boolean delete(AssignPlayerDtoRequest request) {
        if (assignPlayerRepository.existsById(request.getId())) {
            assignPlayerRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}