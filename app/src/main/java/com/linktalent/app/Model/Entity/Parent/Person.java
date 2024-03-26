package com.linktalent.app.Model.Entity.Parent;

import com.linktalent.app.Model.Entity.*;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Token.Token;
import com.linktalent.app.Model.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Person implements UserDetails {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @NotNull(message = "FirstName must be present")
    @Size(min = 1, message = "Firstname cannot be empty")
    @Size(max = 30, message = "Firstname is too long")
    private String firstName;

    @Size(max = 30, message = "Lastname is too long")
    private String lastName;

    private String password;


    private String address;

    @Enumerated(EnumType.STRING)
    private Role role ;

    @Column(unique = true)
    @Email(message = "Email was not provided")
    @Size(max = 80, message = "Email is too long")
    private String email;

    @Pattern(regexp = "0\\d{9}", message = "Phone number must match the format '0XXXXXXXXX'")
    @Column(unique = true)
    private String phoneNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Sport sport;


    // Person Comments
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Comment> comments;


    // Person Posts
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Post> posts;


    // TeamLeader Assigned to Team
    @OneToMany(mappedBy = "id.teamAdmin", fetch = FetchType.LAZY)
    private List<AssignAdmin> assignAdmins;

    // Person Tokens
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Token> tokens;


    // Players Assigned by TeamLeader
    @OneToMany(mappedBy = "leaderAssigned", fetch = FetchType.LAZY)
    private List<AssignPlayer> leaderAssigns;


    // Players Assigned to Team
    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
    private List<AssignPlayer> assignments;


    // Person chats
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<AssignChat> assignChat;


    // Player Applies
    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
    private List<Apply> applies;


    // Person chat groups Creations
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<ChatRoom> chatRooms;


    // player Managers
    @OneToMany(mappedBy = "id.player", fetch = FetchType.LAZY)
    private List<AssignManager> managers;


    // manager Players
    @OneToMany(mappedBy = "id.manager", fetch = FetchType.LAZY)
    private List<AssignManager> players;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


