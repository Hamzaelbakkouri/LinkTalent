package com.linktalent.app.Model.Dto.Media;

import com.linktalent.app.Model.Enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MediaDtoRequest {
    private Integer id;

    @NotBlank(message = "Url cannot be blank")
    private String url;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @NotNull(message = "media type must be not null")
    private MediaType type;

    @NotNull(message = "post id must be not null")
    private UUID post;

    @NotNull(message = "sport id must be not null")
    private UUID sport;
}
