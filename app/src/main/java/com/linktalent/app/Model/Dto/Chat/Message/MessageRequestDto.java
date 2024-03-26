package com.linktalent.app.Model.Dto.Chat.Message;

import com.linktalent.app.Model.Enums.MediaType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class MessageRequestDto {
    private Integer id;

    @NotEmpty(message = "content must be not empty")
    private String content;

    @NotNull(message = "Chat Room id must be not null")
    private UUID chatRoom;

    @NotEmpty(message = "Media Type must be not empty")
    private MediaType mediaType;

    private Integer ParentMessage;
}
