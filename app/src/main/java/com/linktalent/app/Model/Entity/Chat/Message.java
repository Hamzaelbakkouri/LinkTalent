package com.linktalent.app.Model.Entity.Chat;

import com.linktalent.app.Model.Enums.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne
    private ChatRoom chatRoom;

    private MediaType mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message ParentMessage;

}
