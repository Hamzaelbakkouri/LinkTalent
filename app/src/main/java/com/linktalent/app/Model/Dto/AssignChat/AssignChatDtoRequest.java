package com.linktalent.app.Model.Dto.AssignChat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class AssignChatDtoRequest {
    private Integer id;

    @FutureOrPresent
    private LocalDate creationDate;
    @NotNull(message = "person id must be Not Null")
    private UUID person;

    @NotNull(message = "chatRoom id must be Not Null")
    private UUID chatRoom;
}
