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

import java.time.LocalDateTime;
import java.util.Optional;

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
            apply.getId().setApplyingDate(LocalDateTime.now());
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
        Optional<Apply> applyToUpdate = applyRepository.findById(request.getId());
        if (applyToUpdate.isPresent()) {
            Apply apply = modelMapper.map(request, Apply.class);

            Announcement announcement = announcementRepository.findById(request.getId().getAnnouncement().getId()).orElseThrow(() -> new ResourceNotFoundException("Announcement Not Found"));
            Person player = personRepository.findById(request.getId().getPlayer().getId()).orElseThrow(() -> new ResourceNotFoundException("Player Not Found"));
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
        Optional<Apply> apply = applyRepository.findById(embeddedApply);
        return apply.map(value -> modelMapper.map(value, ApplyDtoResponse.class));
    }

    @Override
    public Boolean delete(ApplyDtoRequest request) {
        if (applyRepository.findById(request.getId()).isPresent()) {
            applyRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
