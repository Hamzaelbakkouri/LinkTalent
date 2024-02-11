package com.linktalent.app.Model.Embedded;

import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Team;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EmbeddedAssignPlayer implements Serializable {

    @ManyToOne
    @JoinColumn(name = "player")
    private Person player;

    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

    @FutureOrPresent(message = "date must now or in the future")
    private LocalDateTime assigningDate;
}
