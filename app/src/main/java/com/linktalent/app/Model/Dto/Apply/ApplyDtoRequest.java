package com.linktalent.app.Model.Dto.Apply;

import com.linktalent.app.Model.Dto.Embeddeds.EmbeddedApplyDTO;
import com.linktalent.app.Model.Enums.FileType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ApplyDtoRequest {
    @EmbeddedId
    private EmbeddedApplyDTO id;

    private LocalDate applyingDate;

    @NotNull(message = "File Type Must be Not Null")
    @Enumerated(EnumType.STRING)
    private FileType fileType;


    private String letter;
}
