package com.linktalent.app.Model.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    RECRUITER_READ("leader:read"),

    RECRUITER_UPDATE("leader:update"),

    RECRUITER_CREATE("leader:create"),

    RECRUITER_DELETE("leader:delete"),

    MANAGER_READ("manager:read"),

    MANAGER_UPDATE("manager:update"),

    MANAGER_CREATE("manager:create"),

    MANAGER_DELETE("manager:delete"),

    PLAYER_READ("player:read"),

    PLAYER_UPDATE("player:update"),

    PLAYER_CREATE("player:create"),

    PLAYER_DELETE("player:delete"),

    ADMIN_READ("admin:read"),

    ADMIN_UPDATE("admin:update"),

    ADMIN_CREATE("admin:create"),

    ADMIN_DELETE("admin:delete");

    private final String permission;
}
