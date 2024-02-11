package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Integer> {
}
