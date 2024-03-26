package com.linktalent.app.Model.Dto.AssignManager;

import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AssignManagerDtoResponse {
    @EmbeddedId
    private EmbeddedAssignManager id;

    private Boolean isLeader;
}
