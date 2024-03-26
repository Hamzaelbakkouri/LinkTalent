package com.linktalent.app.Model.Dto.Chat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ChatRoomRequestDTO {
    private UUID id;

    @FutureOrPresent(message = "Date must be Now or Future")
    private LocalDateTime creationDate;

    @NotNull(message = "createBy Id must be not Null")
    private UUID createdBy;
}
