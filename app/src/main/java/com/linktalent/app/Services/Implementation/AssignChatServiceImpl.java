package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignChat.AssignChatDtoRequest;
import com.linktalent.app.Model.Dto.AssignChat.AssignChatDtoResponse;
import com.linktalent.app.Model.Entity.AssignChat;
import com.linktalent.app.Model.Entity.Chat.ChatRoom;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Repository.AssignChatRepository;
import com.linktalent.app.Repository.ChatRoomRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Services.Spec.AssignChatService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignChatServiceImpl implements AssignChatService {
    private final AssignChatRepository assignChatRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssignChatDtoResponse> getAll(Pageable pageable) {
        Page<AssignChat> assignChatPage = assignChatRepository.findAll(pageable);
        return assignChatPage.map(assignChat -> modelMapper.map(assignChat, AssignChatDtoResponse.class));
    }

    @Override
    public Optional<AssignChatDtoResponse> create(AssignChatDtoRequest request) {
        AssignChat assignChat = modelMapper.map(request, AssignChat.class);
        ChatRoom chatRoom = chatRoomRepository.findById(request.getChatRoom()).orElseThrow(() -> new ResourceNotFoundException("Chat Room Not Found"));
        Person person = personRepository.findById(request.getPerson()).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
        if (chatRoom != null && person != null) {
            assignChat.setCreationDate(LocalDate.now());
            assignChat.setChatRoom(chatRoom);
            assignChat.setPerson(person);
            assignChatRepository.save(assignChat);
            return Optional.of(modelMapper.map(assignChat, AssignChatDtoResponse.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<AssignChatDtoResponse> update(AssignChatDtoRequest request) {
        Optional<AssignChat> assignChatToUpdate = assignChatRepository.findById(request.getId());
        if (assignChatToUpdate.isPresent()) {
            AssignChat assignChat = modelMapper.map(request, AssignChat.class);
            ChatRoom chatRoom = chatRoomRepository.findById(request.getChatRoom()).orElseThrow(() -> new ResourceNotFoundException("Chat Room Not Found"));
            Person person = personRepository.findById(request.getPerson()).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
            if (chatRoom != null && person != null) {
                assignChat.setChatRoom(chatRoom);
                assignChat.setPerson(person);
                assignChatRepository.save(assignChat);
                return Optional.of(modelMapper.map(assignChat, AssignChatDtoResponse.class));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignChatDtoResponse> getById(Integer id) {
        Optional<AssignChat> assignChat = assignChatRepository.findById(id);
        return assignChat.map(value -> modelMapper.map(value, AssignChatDtoResponse.class));
    }

    @Override
    public Boolean delete(AssignChatDtoRequest request) {
        if (assignChatRepository.findById(request.getId()).isPresent()) {
            assignChatRepository.deleteById(request.getId());
            return true;
        }
        throw new ResourceNotFoundException("Assign Chat with id : " + request.getId() + " Not Found");
    }
}
