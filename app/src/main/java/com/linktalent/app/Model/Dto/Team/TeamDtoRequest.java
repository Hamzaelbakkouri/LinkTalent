package com.linktalent.app.Model.Dto.Team;

import com.linktalent.app.Model.Dto.Sport.SportRequestDTO;
import com.linktalent.app.Model.Dto.Sport.SportResponseDTO;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TeamDtoRequest {
    private UUID id;
    @NotBlank(message = "name must be not blank")
    private String name;

    @NotNull(message = "sport id must be not null")
    private UUID sport;

    @NotNull(message = "creation date must be not null")
    @FutureOrPresent(message = "creation date must be now or is the future")
    private LocalDateTime creationDate;

    @NotBlank(message = "main location must be not blank")
    private String mainLocation;
}
