package com.linktalent.app.Model.Dto.Announecement;

import com.linktalent.app.Model.Dto.Team.TeamDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AnnouncementDto {
    UUID id;

    String title;

    Integer places;

    String description;

    String location;

    LocalDate creationDate;

    LocalDate endDate;

    String link;

    TeamDto team;
}
