package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Parent.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom , UUID> {
    List<ChatRoom> findAllByCreatedBy(Person person);
}
