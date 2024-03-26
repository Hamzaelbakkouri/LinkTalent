package com.linktalent.app.Services;

import com.linktalent.app.Interfaces.Shared.CrudInterface;
import com.linktalent.app.Model.Entity.Parent.Person;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService implements CrudInterface<Person , UUID> {
    @Override
    public Person create(Person dtoReq) {
        return null;
    }

    @Override
    public Person update(Person dtoReq, UUID uuid) {
        return null;
    }

    @Override
    public Boolean delete(UUID uuid) {
        return null;
    }

    @Override
    public Page<Person> getAll() {
        return null;
    }

    @Override
    public Person getOne(UUID uuid) {
        return null;
    }
}
