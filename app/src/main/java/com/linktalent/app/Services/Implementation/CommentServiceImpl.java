package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Model.Dto.Comment.CommentDtoRequest;
import com.linktalent.app.Model.Dto.Comment.CommentDtoResponse;
import com.linktalent.app.Model.Entity.Comment;
import com.linktalent.app.Repository.CommentRepository;
import com.linktalent.app.Services.Spec.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CommentDtoResponse> getAll(Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findAll(pageable);
        return commentPage.map(comment -> modelMapper.map(comment, CommentDtoResponse.class));
    }

    @Override
    public Optional<CommentDtoResponse> create(CommentDtoRequest request) {
        Comment comment = modelMapper.map(request, Comment.class);
        comment.setCreationDate(LocalDateTime.now());
        commentRepository.save(comment);
        return Optional.of(modelMapper.map(comment, CommentDtoResponse.class));
    }

    @Override
    public Optional<CommentDtoResponse> update(CommentDtoRequest request) {
        Optional<Comment> commentToUpdate = commentRepository.findById(request.getId());
        if (commentToUpdate.isPresent()) {
            Comment comment = modelMapper.map(request, Comment.class);
            commentRepository.save(comment);
            return Optional.of(modelMapper.map(comment, CommentDtoResponse.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<CommentDtoResponse> getById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(value -> modelMapper.map(value, CommentDtoResponse.class));
    }

    @Override
    public Boolean delete(CommentDtoRequest request) {
        if (commentRepository.existsById(request.getId())) {
            commentRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}