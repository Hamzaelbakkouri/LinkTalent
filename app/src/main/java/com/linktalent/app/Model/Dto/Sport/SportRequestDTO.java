package com.linktalent.app.Model.Dto.Sport;


import com.linktalent.app.Model.Enums.SportCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class SportRequestDTO {
    private UUID id;

    @NotEmpty(message = "Name must be Not Empty")
    private String name;

    @NotEmpty(message = "Description must be Not Empty")
    private String description;

    @NotNull(message = "Number Of Players must be Not Empty")
    private Integer numberOfPlayers;

    @NotEmpty(message = "Rules must be Not Empty")
    private List<String> rules;

    @NotEmpty(message = "Category must be Not Empty")
    private SportCategory category;
}
