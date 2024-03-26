package com.linktalent.app.Model.Dto.CommentReaction;

import com.linktalent.app.Model.Entity.Parent.Reaction;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CommentReactionDtoRequest extends Reaction {
    @NotNull(message = "comment id must be not null")
    private Integer comment;
}
