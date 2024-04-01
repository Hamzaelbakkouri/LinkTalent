package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Enums.FileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class Apply {
    @Column(unique = true)
    @EmbeddedId
    private EmbeddedApply id;

    private LocalDate applyingDate;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String letter;
}
