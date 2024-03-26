package com.linktalent.app.Model.Dto.AssignPlayer;

import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import jakarta.persistence.EmbeddedId;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AssignPlayerDtoRequest {
    @EmbeddedId
    private EmbeddedAssignPlayer id;

    @NotNull(message = "contract file must be not null")
    private List<String> contractFile;

    @FutureOrPresent(message = "End date must be in the future")
    private LocalDate endDate;

    @NotNull(message = "Leader Assigned Must be not null")
    private UUID leaderAssigned;
}
