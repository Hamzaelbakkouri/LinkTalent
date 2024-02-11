package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.AssignChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignChatRepository extends JpaRepository<AssignChat, Integer> {
}
