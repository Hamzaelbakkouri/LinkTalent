package com.linktalent.app.Model.Embedded;

import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Parent.Person;
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
public class EmbeddedApply implements Serializable {
    @ManyToOne
    @JoinColumn(name = "announcement")
    private Announcement announcement;

    @ManyToOne
    private Person player;

    @FutureOrPresent(message = "date must in the present or future")
    private LocalDateTime applyingDate;
}
