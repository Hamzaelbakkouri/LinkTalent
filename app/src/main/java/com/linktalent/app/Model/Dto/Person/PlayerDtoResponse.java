package com.linktalent.app.Model.Dto.Person;

import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Dto.AssignPlayer.AssignPlayerDtoRequest;
import com.linktalent.app.Model.Dto.Comment.CommentDtoRequest;
import com.linktalent.app.Model.Dto.Post.PostDtoRequest;
import com.linktalent.app.Model.Entity.*;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Token.Token;
import com.linktalent.app.Model.Enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDtoResponse implements Serializable {
    private UUID id;

    private String firstName;

    private String lastName;

    private String password;

    private String address;

    private Role role;

    private String email;

    private String phoneNumber;

    private Sport sport;

    private List<CommentDtoRequest> comments;

    private List<PostDtoRequest> posts;

//    Person chats
//    private List<AssignChat> assignChat;

    private List<ApplyDtoResponse> applies;

    private List<ChatRoom> chatRooms;

    private List<AssignManager> managers;
}
