package com.linktalent.app.Model.Dto.Embeddeds;

import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class EmbededdedConnectDto implements Serializable {
    private UUID personRequest;

    private UUID personToAccept;
}
