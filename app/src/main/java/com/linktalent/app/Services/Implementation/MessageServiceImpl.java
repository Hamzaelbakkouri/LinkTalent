package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Model.Dto.Chat.Message.MessageRequestDto;
import com.linktalent.app.Model.Dto.Chat.Message.MessageResponseDto;
import com.linktalent.app.Model.Entity.Chat.Message;
import com.linktalent.app.Repository.MessageRepository;
import com.linktalent.app.Services.Spec.MessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;


    @Override
    public Page<MessageResponseDto> getAll(Pageable pageable) {
        Page<Message> messagePage = messageRepository.findAll(pageable);
        return messagePage.map(message -> modelMapper.map(message, MessageResponseDto.class));
    }

    @Override
    public Optional<MessageResponseDto> create(MessageRequestDto request) {
        Optional<Message> message = Optional.of(messageRepository.save(modelMapper.map(request, Message.class)));
        return message.map(value -> modelMapper.map(value, MessageResponseDto.class));
    }

    @Override
    public Optional<MessageResponseDto> update(MessageRequestDto request) {
        Optional<Message> messageToUpdate = messageRepository.findById(request.getId());
        if (messageToUpdate.isPresent()) {
            request.setId(messageToUpdate.get().getId());
            Optional<Message> message = Optional.of(messageRepository.save(modelMapper.map(request, Message.class)));
            return message.map(value -> modelMapper.map(value, MessageResponseDto.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<MessageResponseDto> getById(Integer integer) {
        return Optional.of(modelMapper.map(messageRepository.findById(integer).get(), MessageResponseDto.class));
    }

    @Override
    public Boolean delete(MessageRequestDto request) {
        if (messageRepository.findById(request.getId()).isPresent()) {
            messageRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
