package com.linktalent.app.Model.Dto.Apply;

import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Enums.FileType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplyDtoRequest {
    @EmbeddedId
    private EmbeddedApply id;

    @NotNull(message = "File Type Must be Not Null")
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String letter;
}
