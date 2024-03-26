package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Model.Dto.Post.PostDtoRequest;
import com.linktalent.app.Model.Dto.Post.PostDtoResponse;
import com.linktalent.app.Services.Spec.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public Page<PostDtoResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<PostDtoResponse> create(PostDtoRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<PostDtoResponse> update(PostDtoRequest response) {
        return Optional.empty();
    }

    @Override
    public Optional<PostDtoResponse> getById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(PostDtoRequest response) {
        return null;
    }
}
