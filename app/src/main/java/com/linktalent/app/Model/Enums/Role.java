package com.linktalent.app.Model.Enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum Role {

    USER(Collections.emptySet()),

    PLAYER(
            Set.of(
                    Permission.PLAYER_CREATE,
                    Permission.PLAYER_DELETE,
                    Permission.PLAYER_UPDATE,
                    Permission.PLAYER_READ
            )
    ),
    MANAGER(
            Set.of(Permission.MANAGER_READ,
                    Permission.MANAGER_CREATE,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE
            )
    ),
    TEAMLEADER(
            Set.of(
                    Permission.RECRUITER_CREATE,
                    Permission.RECRUITER_DELETE,
                    Permission.RECRUITER_UPDATE,
                    Permission.RECRUITER_READ
            )
    ),
    ADMIN(
            Set.of(
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_READ,
                    Permission.ADMIN_DELETE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        authorities.addAll(getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());
        return authorities;
    }
}
