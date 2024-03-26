package com.linktalent.app.Services.Spec;

import com.linktalent.app.Model.Dto.Post.PostDtoRequest;
import com.linktalent.app.Model.Dto.Post.PostDtoResponse;

import java.util.UUID;

public interface PostService extends G_Service<PostDtoRequest, PostDtoResponse, UUID> {
}
