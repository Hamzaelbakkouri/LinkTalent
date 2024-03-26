package com.linktalent.app.Model.Dto.AssignManager;

import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import jakarta.persistence.EmbeddedId;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AssignManagerDtoRequest {
    @EmbeddedId
    @NotNull(message = "Id must be Not Null")
    private EmbeddedAssignManager id;

    @NotNull(message = "isLeader must be Not Null")
    private Boolean isLeader;
}
