package com.linktalent.app.Model.Dto.Post;

import com.linktalent.app.Model.Entity.AssignTag;
import com.linktalent.app.Model.Entity.Comment;
import com.linktalent.app.Model.Entity.Media;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.PostReaction;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PostDtoResponse {
    private UUID id;
    private String title;
    private String content;
    private Person person;
    private LocalDateTime creationDate;
    private List<Media> medias;
    private List<AssignTag> tags;
    private List<PostReaction> postReactions;
    private List<Comment> comments;
}
