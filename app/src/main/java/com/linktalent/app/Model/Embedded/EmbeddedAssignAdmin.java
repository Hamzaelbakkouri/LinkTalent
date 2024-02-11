package com.linktalent.app.Model.Embedded;

import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Team;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmbeddedAssignAdmin implements Serializable {
    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "teamAdmin")
    private Person teamAdmin;

    @FutureOrPresent(message = "Date must be Now or in the future")
    private LocalDateTime startLeading;
}
