package com.linktalent.app.Model.Dto.Connect;

import com.linktalent.app.Model.Dto.Embeddeds.EmbededdedConnectDto;
import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import jakarta.persistence.EmbeddedId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectDtoRequest {
    @EmbeddedId
    private EmbededdedConnectDto embeddedConnect;

    private Boolean isConnect;
}
