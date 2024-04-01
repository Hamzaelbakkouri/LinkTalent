package com.linktalent.app.Services.Spec;

import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementResponseDto;
import com.linktalent.app.Model.Entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AnnouncementService extends G_Service<AnnouncementRequestDto, AnnouncementResponseDto, UUID> {
    Page<AnnouncementResponseDto> findAllByTeam(Team team, Pageable pageable);

    Page<AnnouncementResponseDto> getRandomAnnouncement(Pageable pageable);
}
