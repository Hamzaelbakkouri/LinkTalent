package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedAssignAdmin;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public final class AssignAdmin {
    @EmbeddedId
    private EmbeddedAssignAdmin id;

    private Boolean isAdmin;
}
