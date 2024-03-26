package com.linktalent.app.Model.Dto.Announecement;

import com.linktalent.app.Model.Entity.Apply;
import com.linktalent.app.Model.Entity.Team;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AnnouncementRequestDto {
    private UUID id;

    @NotEmpty(message = "title Id must be not Null")
    private String title;

    @NotNull(message = "places must be not Null")
    private Integer places;

    @NotEmpty(message = "description must be not Null")
    private String description;

    @NotEmpty(message = "location must be not Null")
    private String location;

    @FutureOrPresent(message = "creation date must be now or the future")
    private LocalDate creationDate;

    @FutureOrPresent(message = "endDate must be in the future")
    private LocalDate endDate;

    @NotEmpty(message = "Link must be not Empty")
    private String link;

    @NotNull(message = "Team Id must be not Null")
    private UUID team;
}
