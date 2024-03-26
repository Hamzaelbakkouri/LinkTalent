package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Connect {
    @Id
    @EmbeddedId
    private EmbeddedConnect embeddedConnect;

    private Boolean isConnect = false;
}
