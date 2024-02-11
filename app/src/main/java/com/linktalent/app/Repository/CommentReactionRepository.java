package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.CommentReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentReactionRepository extends JpaRepository<CommentReaction , UUID> {
}
