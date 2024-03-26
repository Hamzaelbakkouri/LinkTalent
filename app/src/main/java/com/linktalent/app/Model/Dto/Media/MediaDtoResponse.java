package com.linktalent.app.Model.Dto.Media;

import com.linktalent.app.Model.Entity.Post;
import com.linktalent.app.Model.Entity.Sport;
import com.linktalent.app.Model.Enums.MediaType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDtoResponse {
    private Integer id;
    private String url;
    private String description;
    private MediaType type;
    private Post post;
    private Sport sport;
}
