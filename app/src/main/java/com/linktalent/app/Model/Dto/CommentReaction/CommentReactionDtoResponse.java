package com.linktalent.app.Model.Dto.CommentReaction;

import com.linktalent.app.Model.Entity.Comment;
import com.linktalent.app.Model.Entity.Parent.Reaction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CommentReactionDtoResponse extends Reaction {
    private Comment comment;
}
