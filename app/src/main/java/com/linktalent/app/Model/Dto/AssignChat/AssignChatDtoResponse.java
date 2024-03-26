package com.linktalent.app.Model.Dto.AssignChat;

import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class AssignChatDtoResponse {
    private Integer id;

    @FutureOrPresent
    private LocalDate creationDate;

    private Person person;

    private ChatRoom chatRoom;
}
