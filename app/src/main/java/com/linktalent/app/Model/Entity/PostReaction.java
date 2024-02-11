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
@NoArgsConstructor
@Entity
public final class PostReaction extends Reaction {
    @ManyToOne
    private Post post;
}
