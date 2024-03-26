package com.linktalent.app.Model.Dto.Connect;

import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectDtoResponse {
    @EmbeddedId
    private EmbeddedConnect embeddedConnect;

    private Boolean isConnect;
}
