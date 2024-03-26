package com.linktalent.app.Services.Spec;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface G_Service <R , RS , ID>{

    Page<RS> getAll(Pageable pageable);

    Optional<RS> create(@Valid R request);

    Optional<RS> update(@Valid R response);

    Optional<RS> getById(ID id);

    Boolean delete(@Valid R response);
}
