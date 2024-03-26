package com.linktalent.app.Controllers;


import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Auth.AuthenticationRequest;
import com.linktalent.app.Model.Dto.Auth.AuthenticationResponse;
import com.linktalent.app.Model.Dto.Registration.RegisterRequest;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Services.Spec.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthenticationController {
    private final AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerPlayer(@Valid @RequestBody final RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ResourceNotFoundException(bindingResult.toString());

        return ResponseEntity.ok(service.registerPlayer(request));
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody final AuthenticationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ResourceNotFoundException(bindingResult.toString());

        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register/manager")
    public ResponseEntity<AuthenticationResponse> registerManager(@Valid @RequestBody final RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ResourceNotFoundException(bindingResult.toString());

        return ResponseEntity.ok(service.registerManager(request));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/register/leader")
    public ResponseEntity<AuthenticationResponse> registerLeader(@Valid @RequestBody final RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ResourceNotFoundException(bindingResult.toString());

        return ResponseEntity.ok(service.registerLeader(request));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@Valid @RequestBody final RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ResourceNotFoundException(bindingResult.toString());

        return ResponseEntity.ok(service.registerAdmin(request));
    }
}
