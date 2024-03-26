package com.linktalent.app.Services.Spec;

import com.linktalent.app.Model.Dto.Auth.AuthenticationRequest;
import com.linktalent.app.Model.Dto.Auth.AuthenticationResponse;
import com.linktalent.app.Model.Dto.Person.ProfileDtoResponse;
import com.linktalent.app.Model.Dto.Registration.RegisterRequest;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public interface AuthenticationService {
    AuthenticationResponse registerPlayer(RegisterRequest request);
    AuthenticationResponse registerAdmin(RegisterRequest request);

    AuthenticationResponse registerManager(RegisterRequest request);

    AuthenticationResponse registerLeader(RegisterRequest request);


    AuthenticationResponse authenticate(AuthenticationRequest request);


    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    Boolean checkToken(String token);
    Optional<ProfileDtoResponse> getCurrentUser();
}
