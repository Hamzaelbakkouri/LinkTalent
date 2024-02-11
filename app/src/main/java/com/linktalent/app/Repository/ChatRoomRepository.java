package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom , UUID> {
}
