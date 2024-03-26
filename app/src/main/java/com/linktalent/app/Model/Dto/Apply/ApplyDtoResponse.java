package com.linktalent.app.Model.Dto.Apply;

import com.linktalent.app.Model.Enums.FileType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApplyDtoResponse {
    private FileType fileType;

    private String letter;
}
