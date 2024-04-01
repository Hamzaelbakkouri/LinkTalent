package com.linktalent.app.Model.Dto.Apply;

import com.linktalent.app.Model.Dto.Embeddeds.EmbeddedApplyDTO;
import com.linktalent.app.Model.Enums.FileType;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ApplyDtoResponse {
    @EmbeddedId
    private EmbeddedApplyDTO id;

    private FileType fileType;

    private LocalDate applyingDate;

    private String letter;
}
