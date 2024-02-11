package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Entity.Parent.Reaction;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public final class CommentReaction extends Reaction {
    @ManyToOne
    private Comment comment;
}
