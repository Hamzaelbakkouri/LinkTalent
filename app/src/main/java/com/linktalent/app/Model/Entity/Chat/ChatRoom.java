package com.linktalent.app.Model.Entity.Chat;

import com.linktalent.app.Model.Entity.AssignChat;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public final class ChatRoom {
    @Id
    @UuidGenerator
    private UUID id;

    @FutureOrPresent
    private LocalDateTime creationDate;

    @ManyToOne
    private Person createdBy;

    @OneToMany(mappedBy = "chatRoom")
    private List<Message> messages;

    @OneToMany(mappedBy = "chatRoom")
    private List<AssignChat> assignChats;
}
