package com.linktalent.app.Model.Dto.Post;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PostDtoRequest {
    private UUID id;

    @NotBlank(message = "title Must be not blank")
    private String title;

    @NotBlank(message = "content Must be not blank")
    private String content;

    @NotNull(message = "person id must be not null")
    private UUID person;

    @FutureOrPresent(message = "creationDate must now or in future")
    private LocalDateTime creationDate;
}
