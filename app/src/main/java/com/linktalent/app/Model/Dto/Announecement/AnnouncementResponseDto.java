package com.linktalent.app.Model.Dto.Announecement;

import com.linktalent.app.Model.Entity.Apply;
import com.linktalent.app.Model.Entity.Team;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class AnnouncementResponseDto {
    private UUID id;

    private String title;

    private Integer places;

    private String description;

    private String location;

    private LocalDate creationDate;

    private LocalDate endDate;

    private String link;

    private Team team;

    private List<Apply> applies;
}
