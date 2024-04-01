package com.linktalent.app.Model.Dto.Person;

import com.linktalent.app.Model.Dto.Sport.SportRequestDTO;
import com.linktalent.app.Model.Enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class ProfileDtoResponse implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private Role role;
    private String email;
    private String phoneNumber;
    private SportRequestDTO sport;
}
