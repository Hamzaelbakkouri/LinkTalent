package com.linktalent.app.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public final class Team {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Sport sport;

    @FutureOrPresent(message = "Date must be now or Future")
    private LocalDateTime creationDate;

    private String mainLocation;

    @OneToMany(mappedBy = "id.team")
    private List<AssignPlayer> players;

    @OneToMany(mappedBy = "team")
    private List<Announcement> announcements;

    @OneToMany(mappedBy = "id.team")
    private List<AssignAdmin> Admins;
}
