package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Connect.ConnectDtoRequest;
import com.linktalent.app.Model.Dto.Connect.ConnectDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import com.linktalent.app.Model.Entity.Connect;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Repository.ConnectRepository;
import com.linktalent.app.Repository.PersonRepository;
import com.linktalent.app.Services.Spec.ConnectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConnectServiceImpl implements ConnectService {
    private final ConnectRepository connectRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<ConnectDtoResponse> getAll(Pageable pageable) {
        Page<Connect> connectPage = connectRepository.findAll(pageable);
        return connectPage.map(connect -> modelMapper.map(connect, ConnectDtoResponse.class));
    }

    @Override
    public Optional<ConnectDtoResponse> create(ConnectDtoRequest request) {
        Person person1 = personRepository.findById(request.getEmbeddedConnect().getPersonRequest()).orElseThrow(() -> new ResourceNotFoundException("Person Request Not Found"));
        Person person2 = personRepository.findById(request.getEmbeddedConnect().getPersonRequest()).orElseThrow(() -> new ResourceNotFoundException("Person Request Not Found"));
        EmbeddedConnect embeddedConnect = new EmbeddedConnect();
        embeddedConnect.setPersonRequest(person1);
        embeddedConnect.setPersonRequest(person2);
        Connect connect = new Connect();
        connect.setEmbeddedConnect(embeddedConnect);
        connect.setIsConnect(request.getIsConnect());
        connectRepository.save(connect);
        return Optional.of(modelMapper.map(connect, ConnectDtoResponse.class));
    }

    @Override
    public Optional<ConnectDtoResponse> update(ConnectDtoRequest request) {
        Person person1 = personRepository.findById(request.getEmbeddedConnect().getPersonRequest()).orElseThrow(() -> new ResourceNotFoundException("Person Request Not Found"));
        Person person2 = personRepository.findById(request.getEmbeddedConnect().getPersonRequest()).orElseThrow(() -> new ResourceNotFoundException("Person Request Not Found"));
        EmbeddedConnect embeddedConnect = new EmbeddedConnect();
        embeddedConnect.setPersonRequest(person1);
        embeddedConnect.setPersonRequest(person2);
        Optional<Connect> connectToUpdate = connectRepository.findById(embeddedConnect);
        if (connectToUpdate.isPresent()) {
            Connect connect = connectToUpdate.get();
            connectRepository.save(connect);
            return Optional.of(modelMapper.map(connect, ConnectDtoResponse.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ConnectDtoResponse> getById(EmbeddedConnect embeddedConnect) {
        Optional<Connect> connect = connectRepository.findById(embeddedConnect);
        return connect.map(value -> modelMapper.map(value, ConnectDtoResponse.class));
    }

    @Override
    public Boolean delete(ConnectDtoRequest request) {
        return true;
    }
}
