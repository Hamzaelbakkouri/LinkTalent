package com.linktalent.app.Model.Dto.Team;

import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementResponseDto;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoRequest;
import com.linktalent.app.Model.Dto.AssignAdmin.AssignAdminDtoResponse;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoRequest;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoResponse;
import com.linktalent.app.Model.Dto.Sport.SportRequestDTO;
import com.linktalent.app.Model.Dto.Sport.SportResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TeamDtoResponse {
    private UUID id;

    private String name;

    private SportRequestDTO sport;

    private LocalDateTime creationDate;

    private String mainLocation;

    private List<AssignPlayerDtoRequest> players;

    private List<AnnouncementRequestDto> announcements;

    private List<AssignAdminDtoRequest> Admins;
}
