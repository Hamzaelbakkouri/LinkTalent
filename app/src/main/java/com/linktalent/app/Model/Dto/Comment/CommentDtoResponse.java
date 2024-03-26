package com.linktalent.app.Model.Dto.Comment;


import com.linktalent.app.Model.Entity.Comment;
import com.linktalent.app.Model.Entity.CommentReaction;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Post;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommentDtoResponse {
    private Integer id;

    private String text;

    private LocalDateTime creationDate;

    private Comment commentParent;

    private Person person;

    private Post post;

    // Comment Reaction
    private List<CommentReaction> commentReactions;

    // Comment Replies
    private List<Comment> reply;
}
