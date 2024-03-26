package com.linktalent.app.Model.Dto.Chat;

import com.linktalent.app.Model.Entity.AssignChat;
import com.linktalent.app.Model.Entity.Chat.Message;
import com.linktalent.app.Model.Entity.Parent.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ChatRoomResponseDTO {
    private UUID id;

    private LocalDateTime creationDate;

    private Person createdBy;

    private List<Message> messages;

    private List<AssignChat> assignChats;
}
