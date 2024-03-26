package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Enums.FileType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class Apply {
    @EmbeddedId
    private EmbeddedApply id;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String letter;
}
