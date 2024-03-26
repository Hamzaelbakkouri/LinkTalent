package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementResponseDto;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Repository.AnnouncementRepository;
import com.linktalent.app.Repository.TeamRepository;
import com.linktalent.app.Services.Spec.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;


    @Override
    public Page<AnnouncementResponseDto> getAll(Pageable pageable) {
        Page<Announcement> announcementPage = announcementRepository.findAll(pageable);
        return announcementPage.map(announcement -> modelMapper.map(announcement, AnnouncementResponseDto.class));
    }

    @Override
    public Optional<AnnouncementResponseDto> create(AnnouncementRequestDto request) {
        Optional<Team> team = this.teamRepository.findById(request.getTeam());
        if (team.isPresent()) {
            Announcement announcementToSave = this.modelMapper.map(request, Announcement.class);
            announcementToSave.setTeam(team.get());
            return Optional.of(this.modelMapper.map(this.announcementRepository.save(announcementToSave), AnnouncementResponseDto.class));
        }
        throw new ResourceNotFoundException("Team with Id :" + request.getTeam() + "Not Found");
    }

    @Override
    public Optional<AnnouncementResponseDto> update(AnnouncementRequestDto request) {
        Optional<Announcement> announcementOptional = this.announcementRepository.findById(request.getId());
        if (announcementOptional.isPresent()) {
            Optional<Team> team = this.teamRepository.findById(request.getTeam());
            if (team.isPresent()) {
                Announcement announcementToSave = this.modelMapper.map(request, Announcement.class);
                announcementToSave.setId(request.getId());
                announcementToSave.setTeam(team.get());
                return Optional.of(this.modelMapper.map(this.announcementRepository.save(announcementToSave), AnnouncementResponseDto.class));
            }
            throw new ResourceNotFoundException("Team with Id :" + request.getTeam() + "Not Found");
        }
        throw new ResourceNotFoundException("Announcement with Id :" + request.getId() + "Not Found");
    }

    @Override
    public Optional<AnnouncementResponseDto> getById(UUID uuid) {
        Optional<Announcement> announcementOptional = this.announcementRepository.findById(uuid);
        if (announcementOptional.isPresent()) {
            return Optional.ofNullable(this.modelMapper.map(announcementOptional.get(), AnnouncementResponseDto.class));
        }
        throw new ResourceNotFoundException("Announcement with Id :" + uuid + "Not Found");
    }

    @Override
    public Boolean delete(AnnouncementRequestDto response) {
        Optional<Announcement> announcementOptional = this.announcementRepository.findById(response.getId());
        if (announcementOptional.isPresent()) {
            this.announcementRepository.deleteById(response.getId());
            return true;
        }
        throw new ResourceNotFoundException("Announcement with Id :" + response.getId() + "Not Found");
    }

    @Override
    public Page<AnnouncementResponseDto> findAllByTeam(Team team, Pageable pageable) {
        Optional<Team> AnnouncementTeam = this.teamRepository.findById(team.getId());
        if (AnnouncementTeam.isPresent()) {
            Page<Announcement> announcementPage = announcementRepository.findAllByTeam(AnnouncementTeam.get(), pageable);
            return announcementPage.map(announcement -> modelMapper.map(announcement, AnnouncementResponseDto.class));
        }
        throw new ResourceNotFoundException("Team with id :" + team.getId() + "Not Found");
    }
}
