package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public final class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @FutureOrPresent
    private LocalDateTime creationDate;

    @ManyToOne
    private Comment commentParent;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Post post;

    // Comment Reaction
    @OneToMany(mappedBy = "comment")
    private List<CommentReaction> commentReactions;

    // Comment Replies
    @OneToMany(mappedBy = "commentParent")
    private List<Comment> reply;

}
