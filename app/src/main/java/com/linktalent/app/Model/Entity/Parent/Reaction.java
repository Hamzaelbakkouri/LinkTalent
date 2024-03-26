package com.linktalent.app.Model.Entity.Parent;

import com.linktalent.app.Model.Enums.ReactionType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
public class Reaction {
    @Id
    @UuidGenerator
    private UUID id;

    private ReactionType type;
}
