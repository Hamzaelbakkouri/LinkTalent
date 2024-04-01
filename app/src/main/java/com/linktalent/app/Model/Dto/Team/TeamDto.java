package com.linktalent.app.Model.Dto.Team;

import com.linktalent.app.Model.Dto.Sport.SportRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {
    private UUID id;

    private String name;

    private SportRequestDTO sport;

    private LocalDateTime creationDate;

    private String mainLocation;

}
