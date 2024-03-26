package com.linktalent.app.Model.Dto.AssignPlayer;

import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AssignPlayerDtoResponse {
    @EmbeddedId
    private EmbeddedAssignPlayer id;

    private List<String> contractFile;

    private LocalDate endDate;

    private Person leaderAssigned;

}
