package com.linktalent.app.TestService;

import com.linktalent.app.Model.Dto.Auth.AuthenticationRequest;
import com.linktalent.app.Model.Dto.Auth.AuthenticationResponse;
import com.linktalent.app.Model.Dto.Registration.RegisterRequest;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Repository.SportRepository;
import com.linktalent.app.Repository.TokenRepository;
import com.linktalent.app.Security.JwtService;
import com.linktalent.app.Services.Implementation.AuthenticationServiceImpl;
import com.linktalent.app.Services.Spec.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthenticateWork() {
        AuthenticationRequest authenticationRequestDto = new AuthenticationRequest();
        authenticationRequestDto.setEmail("testUser@gmail.com");
        authenticationRequestDto.setPassword("password");

        Person user = new Person();
        user.setEmail("testUser@gmail.com");
        user.setPassword("encodedPassword");

        when(personRepository.findByEmail("testUser@gmail.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(authenticationRequestDto.getPassword(), user.getPassword())).thenReturn(true);
        when(jwtService.generateToken(any(Person.class))).thenReturn("accessToken");

        AuthenticationResponse responseDto = authenticationService.authenticate(authenticationRequestDto);

        assertNotNull(responseDto);
        assertNotNull(responseDto.getAccessToken());
    }

    @Test
    void AuthenticateUserNotFound() {
        AuthenticationRequest authenticationRequestDto = new AuthenticationRequest();
        authenticationRequestDto.setEmail("nonExistingUser");
        authenticationRequestDto.setPassword("password");

        when(personRepository.findByEmail("nonExistingUser")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> authenticationService.authenticate(authenticationRequestDto));
    }
}
