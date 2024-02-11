package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Enums.MediaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public final class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String url;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @Enumerated(EnumType.STRING)
    private MediaType type;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Sport sport;
}
