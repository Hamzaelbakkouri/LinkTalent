package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public final class AssignManager {
    @EmbeddedId
    private EmbeddedAssignManager id;

    private Boolean isLeader;
}
