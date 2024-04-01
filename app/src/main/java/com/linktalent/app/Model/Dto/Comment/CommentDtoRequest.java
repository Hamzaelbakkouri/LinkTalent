package com.linktalent.app.Model.Dto.Comment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CommentDtoRequest {
    private Integer id;

    private String text;

    private Integer commentParent;

    private UUID person;

    private UUID post;
}
