package com.linktalent.app.Interfaces.Shared;

import org.springframework.data.domain.Page;


public interface CrudInterface <entity,Id>{
    entity create(entity dtoReq);
    entity update(entity dtoReq,Id id);
    Boolean delete(Id id);
    Page<entity> getAll();
    entity getOne(Id id);
}
