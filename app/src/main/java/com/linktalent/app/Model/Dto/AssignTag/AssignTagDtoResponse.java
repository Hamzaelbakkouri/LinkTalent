package com.linktalent.app.Model.Dto.AssignTag;

import com.linktalent.app.Model.Dto.Sport.SportResponseDTO;
import com.linktalent.app.Model.Entity.Post;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssignTagDtoResponse {
    private Integer id;

    @NotNull(message = "post id must be not null")
    private Post post;

    @NotNull(message = "sport id must be not null")
    private SportResponseDTO sport;

    @FutureOrPresent(message = "date must be now or in the future")
    private LocalDateTime creationDate;
}
