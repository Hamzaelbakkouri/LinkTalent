package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoRequest;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Apply;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Repository.AnnouncementRepository;
import com.linktalent.app.Repository.ApplyRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Services.Spec.ApplyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {
    private final ApplyRepository applyRepository;
    private final AnnouncementRepository announcementRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<ApplyDtoResponse> getAll(Pageable pageable) {
        Page<Apply> applyPage = applyRepository.findAll(pageable);
        return applyPage.map(apply -> modelMapper.map(apply, ApplyDtoResponse.class));
    }

    @Override
    public Optional<ApplyDtoResponse> create(ApplyDtoRequest request) {
        Apply apply = modelMapper.map(request, Apply.class);
        Announcement announcement = announcementRepository.findById(request.getId().getAnnouncement().getId()).orElseThrow(() -> new ResourceNotFoundException("Announcement Not Found"));
        Person player = personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found"));
        if (announcement != null && player != null) {
            EmbeddedApply embeddedApply = new EmbeddedApply();
            embeddedApply.setAnnouncement(announcement);
            embeddedApply.setPlayer(player);
            apply.setApplyingDate(LocalDate.now());
            apply.getId().setAnnouncement(announcement);
            apply.getId().setPlayer(player);
            applyRepository.save(apply);
            return Optional.of(modelMapper.map(apply, ApplyDtoResponse.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ApplyDtoResponse> update(ApplyDtoRequest request) {
        EmbeddedApply embeddedApply = new EmbeddedApply();
        Announcement announcement = announcementRepository.findById(request.getId().getAnnouncement().getId()).orElseThrow(() -> new ResourceNotFoundException("Announcement Not Found"));
        Person player = personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found"));
        embeddedApply.setPlayer(player);
        embeddedApply.setAnnouncement(announcement);
        Optional<Apply> applyToUpdate = applyRepository.findById(embeddedApply);
        if (applyToUpdate.isPresent()) {
            Apply apply = modelMapper.map(request, Apply.class);
            if (announcement != null && player != null) {
                apply.getId().setAnnouncement(announcement);
                apply.getId().setPlayer(player);
                applyRepository.save(apply);
                return Optional.of(modelMapper.map(apply, ApplyDtoResponse.class));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ApplyDtoResponse> getById(EmbeddedApply embeddedApply) {
        Announcement announcement = this.announcementRepository.findById(embeddedApply.getAnnouncement().getId()).orElseThrow(() -> new ResourceNotFoundException("Announcement not found"));
        Person player = this.personRepository.findById(embeddedApply.getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player not found"));
        embeddedApply.setAnnouncement(announcement);
        embeddedApply.setPlayer(player);
        Optional<Apply> apply = applyRepository.findById(embeddedApply);
        return Optional.of(modelMapper.map(apply.get(), ApplyDtoResponse.class));
    }

    @Override
    public Boolean delete(ApplyDtoRequest request) {
        Apply announcement = modelMapper.map(request, Apply.class);
        if (applyRepository.findById(announcement.getId()).isPresent()) {
            applyRepository.deleteById(announcement.getId());
            return true;
        }
        return false;
    }


    @Override
    public Page<ApplyDtoResponse> getUserApplication(UUID Id, Pageable pageable) {
        this.personRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("person not found"));
        Page<Apply> applications = this.applyRepository.findAllById_Player_Id(Id, pageable);
        return applications.map(apply -> modelMapper.map(apply, ApplyDtoResponse.class));
    }
}
