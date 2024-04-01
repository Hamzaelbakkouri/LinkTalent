package com.linktalent.app.Model.Dto.AssignAdmin;

import com.linktalent.app.Model.Embedded.EmbeddedAssignAdmin;
import jakarta.persistence.EmbeddedId;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssignAdminDtoRequest {
    @EmbeddedId
    @NotNull(message = "id must be Not Null")
    private EmbeddedAssignAdmin id;

    @NotNull(message = "isAdmin must be Not Null")
    private Boolean isAdmin;
}
