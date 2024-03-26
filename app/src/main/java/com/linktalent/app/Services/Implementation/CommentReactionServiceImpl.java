package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.CommentReaction.CommentReactionDtoRequest;
import com.linktalent.app.Model.Dto.CommentReaction.CommentReactionDtoResponse;
import com.linktalent.app.Model.Entity.Comment;
import com.linktalent.app.Model.Entity.CommentReaction;
import com.linktalent.app.Repository.CommentReactionRepository;
import com.linktalent.app.Repository.CommentRepository;
import com.linktalent.app.Services.Spec.CommentReactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentReactionServiceImpl implements CommentReactionService {
    private final CommentReactionRepository commentReactionRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CommentReactionDtoResponse> getAll(Pageable pageable) {
        Page<CommentReaction> commentReactions = commentReactionRepository.findAll(pageable);
        return commentReactions.map(commentReaction -> modelMapper.map(commentReaction, CommentReactionDtoResponse.class));
    }

    @Override
    public Optional<CommentReactionDtoResponse> create(CommentReactionDtoRequest request) {
        Optional<Comment> existingComment = this.commentRepository.findById(request.getComment());
        CommentReaction commentReaction = modelMapper.map(request, CommentReaction.class);
        commentReaction.setComment(existingComment.get());
        CommentReaction savedCommentReaction = commentReactionRepository.save(commentReaction);
        return Optional.of(modelMapper.map(savedCommentReaction, CommentReactionDtoResponse.class));
    }

    @Override
    public Optional<CommentReactionDtoResponse> update(CommentReactionDtoRequest request) {
        Optional<CommentReaction> existingCommentReaction = commentReactionRepository.findById(request.getId());
        Optional<Comment> existingComment = this.commentRepository.findById(request.getComment());
        if (existingCommentReaction.isPresent() && existingComment.isPresent()) {
            CommentReaction commentReaction = existingCommentReaction.get();
            commentReaction.setComment(existingComment.get());
            CommentReaction updatedCommentReaction = commentReactionRepository.save(commentReaction);
            return Optional.of(modelMapper.map(updatedCommentReaction, CommentReactionDtoResponse.class));
        }
        throw new ResourceNotFoundException("Comment or Comment Reaction Not Found");
    }

    @Override
    public Optional<CommentReactionDtoResponse> getById(UUID uuid) {
        Optional<CommentReaction> commentReaction = commentReactionRepository.findById(uuid);
        return commentReaction.map(value -> modelMapper.map(value, CommentReactionDtoResponse.class));
    }

    @Override
    public Boolean delete(CommentReactionDtoRequest request) {
        if (commentReactionRepository.existsById(request.getId())) {
            commentReactionRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
