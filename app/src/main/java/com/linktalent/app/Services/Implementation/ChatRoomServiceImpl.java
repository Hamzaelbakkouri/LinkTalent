package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Model.Dto.Chat.ChatRoomRequestDTO;
import com.linktalent.app.Model.Dto.Chat.ChatRoomResponseDTO;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Repository.ChatRoomRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Services.Spec.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ModelMapper modelMapper;
    private final ChatRoomRepository chatRoomRepository;
    private final PersonRepository personRepository;

    @Override
    public List<ChatRoomResponseDTO> getChtRoomByPerson(UUID uuid) {
        Optional<Person> person = this.personRepository.findById(uuid);
        return person.map(value -> this.chatRoomRepository.findAllByCreatedBy(value)
                .stream()
                .map(chatRoom ->
                        this.modelMapper.map(chatRoom, ChatRoomResponseDTO.class))
                .collect(Collectors.toList())).orElse(null);
    }

    @Override
    public Page<ChatRoomResponseDTO> getAll(Pageable pageable) {
        Page<ChatRoom> chatPage = chatRoomRepository.findAll(pageable);
        return chatPage.map(chat -> modelMapper.map(chat, ChatRoomResponseDTO.class));
    }

    @Override
    public Optional<ChatRoomResponseDTO> create(ChatRoomRequestDTO request) {
        Optional<ChatRoom> chat = Optional.of(chatRoomRepository.save(modelMapper.map(request, ChatRoom.class)));
        return chat.map(value -> modelMapper.map(value, ChatRoomResponseDTO.class));
    }

    @Override
    public Optional<ChatRoomResponseDTO> update(ChatRoomRequestDTO request) {
        Optional<ChatRoom> chatToUpdate = chatRoomRepository.findById(request.getId());
        if (chatToUpdate.isPresent()) {
            request.setId(chatToUpdate.get().getId());
            Optional<ChatRoom> chat = Optional.of(chatRoomRepository.save(modelMapper.map(request, ChatRoom.class)));
            return chat.map(value -> modelMapper.map(value, ChatRoomResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ChatRoomResponseDTO> getById(UUID uuid) {
        return Optional.of(modelMapper.map(chatRoomRepository.findById(uuid).get(), ChatRoomResponseDTO.class));
    }

    @Override
    public Boolean delete(ChatRoomRequestDTO request) {
        if (chatRoomRepository.findById(request.getId()).isPresent()) {
            chatRoomRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
