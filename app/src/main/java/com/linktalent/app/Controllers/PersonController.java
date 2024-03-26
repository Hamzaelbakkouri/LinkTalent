package com.linktalent.app.Controllers;

import com.linktalent.app.Model.Dto.Person.ProfileDtoResponse;
import com.linktalent.app.Services.Spec.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
@Validated
public class PersonController {
    private final AuthenticationService service;

    @PreAuthorize("hasAnyAuthority('ROLE_PLAYER', 'ROLE_MANAGER','ROLE_TEAMLEADER','ROLE_ADMIN')")
    @GetMapping("/profile")
    public ResponseEntity<?> getCurrentUser() {
        Optional<ProfileDtoResponse> authenticatedPerson = this.service.getCurrentUser();
        if (authenticatedPerson.isPresent()) {
            return ResponseEntity.ok(authenticatedPerson.get());
        }
        return ResponseEntity.ofNullable("Person Not Found , Try Sign In");
    }
}
