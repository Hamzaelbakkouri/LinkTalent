package com.linktalent.app.Model.Dto.Person;

import com.linktalent.app.Model.Entity.*;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Token.Token;
import com.linktalent.app.Model.Enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class TeamLeaderDtoResponse {
    private UUID id;

    private String firstName;

    private String lastName;

    private String password;

    private String address;

    private Role role ;

    private String email;

    private String phoneNumber;

    private Sport sport;


    // Person Comments
    private List<Comment> comments;


    // Person Posts
    private List<Post> posts;


    // TeamLeader Assigned to Team
    private List<AssignAdmin> assignAdmins;

    // Person Tokens
    private List<Token> tokens;


    // Players Assigned by TeamLeader
    private List<AssignPlayer> leaderAssigns;


    // Players Assigned to Team
    private List<AssignPlayer> assignments;


    // Person chats
    private List<AssignChat> assignChat;


    // Player Applies
    private List<Apply> applies;


    // Person chat groups Creations
    private List<ChatRoom> chatRooms;


    // player Managers
    private List<AssignManager> managers;


    // manager Players
    private List<AssignManager> players;
}
