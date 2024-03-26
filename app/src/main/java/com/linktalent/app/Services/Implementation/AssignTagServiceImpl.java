package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.AssignTag.AssignTagDtoRequest;
import com.linktalent.app.Model.Dto.AssignTag.AssignTagDtoResponse;
import com.linktalent.app.Model.Entity.AssignTag;
import com.linktalent.app.Repository.AssignTagRepository;
import com.linktalent.app.Repository.PostRepository;
import com.linktalent.app.Repository.SportRepository;
import com.linktalent.app.Services.Spec.AssignTagService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignTagServiceImpl implements AssignTagService {
    private final AssignTagRepository assignTagRepository;
    private final PostRepository postRepository;
    private final SportRepository sportRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssignTagDtoResponse> getAll(Pageable pageable) {
        Page<AssignTag> assignTagPage = assignTagRepository.findAll(pageable);
        return assignTagPage.map(assignTag -> modelMapper.map(assignTag, AssignTagDtoResponse.class));
    }

    @Override
    public Optional<AssignTagDtoResponse> create(AssignTagDtoRequest request) {
        AssignTag assignTag = modelMapper.map(request, AssignTag.class);
        assignTag.setCreationDate(LocalDateTime.now());
        assignTag.setPost(postRepository.findById(request.getPost()).orElseThrow(() -> new ResourceNotFoundException("Post Not Found")));
        assignTag.setSport(sportRepository.findById(request.getSport()).orElseThrow(() -> new ResourceNotFoundException("Sport Not Found")));
        assignTagRepository.save(assignTag);
        return Optional.of(modelMapper.map(assignTag, AssignTagDtoResponse.class));
    }

    @Override
    public Optional<AssignTagDtoResponse> update(AssignTagDtoRequest request) {
        Optional<AssignTag> assignTagToUpdate = assignTagRepository.findById(request.getId());
        if (assignTagToUpdate.isPresent()) {
            AssignTag assignTag = modelMapper.map(request, AssignTag.class);
            assignTag.setPost(postRepository.findById(request.getPost()).orElseThrow(() -> new ResourceNotFoundException("Post Not Found")));
            assignTag.setSport(sportRepository.findById(request.getSport()).orElseThrow(() -> new ResourceNotFoundException("Sport Not Found")));
            assignTagRepository.save(assignTag);
            return Optional.of(modelMapper.map(assignTag, AssignTagDtoResponse.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignTagDtoResponse> getById(Integer id) {
        Optional<AssignTag> assignTag = assignTagRepository.findById(id);
        return assignTag.map(value -> modelMapper.map(value, AssignTagDtoResponse.class));
    }

    @Override
    public Boolean delete(AssignTagDtoRequest request) {
        if (assignTagRepository.existsById(request.getId())) {
            assignTagRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}