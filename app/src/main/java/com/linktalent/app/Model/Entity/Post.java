package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public final class Post {
    @Id
    @UuidGenerator
    private UUID id;

    private String title;

    private String content;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "post")
    private List<Media> medias;

    @FutureOrPresent(message = "date must be now or in the future")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "post")
    private List<AssignTag> tags;

    @OneToMany(mappedBy = "post")
    private List<PostReaction> postReactions;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
