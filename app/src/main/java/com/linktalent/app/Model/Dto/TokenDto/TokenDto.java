package com.linktalent.app.Model.Dto.TokenDto;

import com.linktalent.app.Model.Enums.TokenType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TokenDto {
    private UUID id;
    public String token;
    private TokenType tokenType;
    private boolean revoked;
    private boolean expired;
}
