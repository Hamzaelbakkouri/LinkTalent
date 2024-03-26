package com.linktalent.app.Model.Dto.AssignTag;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AssignTagDtoRequest {
    private Integer id;

    @NotNull(message = "post id must be not null")
    private UUID post;

    @NotNull(message = "sport id must be not null")
    private UUID sport;

    @FutureOrPresent(message = "date must be now or in the future")
    private LocalDateTime creationDate;
}
