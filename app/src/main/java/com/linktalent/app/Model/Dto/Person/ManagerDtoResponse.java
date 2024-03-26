package com.linktalent.app.Model.Dto.Person;

import com.linktalent.app.Model.Dto.TokenDto.TokenDto;
import com.linktalent.app.Model.Entity.*;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Enums.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ManagerDtoResponse {
    private UUID id;

    private String firstName;

    private String lastName;

    private String password;


    private String address;

    @Enumerated(EnumType.STRING)
    private Role role ;

    private String email;

    private String phoneNumber;

    private Sport sport;


    // Person Comments
//    private List<Comment> comments;
//
//
//    // Person Posts
//    private List<Post> posts;
//
//    // Person Tokens
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    private List<TokenDto> tokens;
//
//
//    // Players Assigned by TeamLeader
//    @OneToMany(mappedBy = "leaderAssigned", fetch = FetchType.LAZY)
//    private List<AssignPlayer> leaderAssigns;
//
//
//    // Players Assigned to Team
//    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
//    private List<AssignPlayer> assignments;
//
//
//    // Person chats
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
//    private List<AssignChat> assignChat;
//
//
//    // Player Applies
//    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
//    private List<Apply> applies;
//
//
//    // Person chat groups Creations
//    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
//    private List<ChatRoom> chatRooms;
//
//
//    // player Managers
//    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
//    private List<AssignManager> managers;
//
//
//    // manager Players
//    @OneToMany(mappedBy = "id.manager", fetch = FetchType.LAZY)
//    private List<AssignManager> players;
}
