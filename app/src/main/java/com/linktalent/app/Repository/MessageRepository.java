package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message , Integer> {
}
