package com.linktalent.app.Services.Spec;

import com.linktalent.app.Model.Dto.Chat.ChatRoomRequestDTO;
import com.linktalent.app.Model.Dto.Chat.ChatRoomResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ChatRoomService extends G_Service<ChatRoomRequestDTO, ChatRoomResponseDTO, UUID> {
    List<ChatRoomResponseDTO> getChtRoomByPerson(UUID uuid);
}
