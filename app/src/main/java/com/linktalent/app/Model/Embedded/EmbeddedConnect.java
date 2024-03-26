package com.linktalent.app.Model.Embedded;

import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmbeddedConnect implements Serializable {
    @ManyToOne
    @JoinColumn(name = "personRequest")
    private Person personRequest;

    @ManyToOne
    @JoinColumn(name = "personToAccept")
    private Person personToAccept;
}
