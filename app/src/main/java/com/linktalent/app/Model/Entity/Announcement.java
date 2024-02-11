package com.linktalent.app.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class Announcement {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique = true)
    private String title;

    private Integer places;

    private String description;

    private String location;

    private LocalDate creationDate;

    private LocalDate endDate;

    private String link;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "id.announcement")
    private List<Apply> applies;
}
