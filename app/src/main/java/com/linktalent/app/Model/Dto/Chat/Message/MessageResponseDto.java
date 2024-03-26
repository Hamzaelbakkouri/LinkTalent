package com.linktalent.app.Model.Dto.Chat.Message;

import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Chat.Message;
import com.linktalent.app.Model.Enums.MediaType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageResponseDto {
    private Integer id;

    private String content;

    private ChatRoom chatRoom;

    private MediaType mediaType;

    private Message ParentMessage;
}
