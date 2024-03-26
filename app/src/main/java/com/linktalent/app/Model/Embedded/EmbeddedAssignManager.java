package com.linktalent.app.Model.Embedded;

import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.Embeddable;
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
public class EmbeddedAssignManager implements Serializable {
    @ManyToOne
    private Person player;

    @ManyToOne
    private Person manager;

    private LocalDateTime assignDate;
}
