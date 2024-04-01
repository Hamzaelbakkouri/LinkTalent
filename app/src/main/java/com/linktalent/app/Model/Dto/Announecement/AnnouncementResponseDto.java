package com.linktalent.app.Model.Dto.Announecement;

import com.linktalent.app.Model.Dto.Apply.ApplyDtoRequest;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Dto.Team.TeamDto;
import com.linktalent.app.Model.Dto.Team.TeamDtoRequest;
import com.linktalent.app.Model.Dto.Team.TeamDtoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AnnouncementResponseDto {
    UUID id;

    String title;

    Integer places;

    String description;

    String location;

    LocalDate creationDate;

    LocalDate endDate;

    String link;

    TeamDto team;

//    List<ApplyDtoRequest> applies ;
}
