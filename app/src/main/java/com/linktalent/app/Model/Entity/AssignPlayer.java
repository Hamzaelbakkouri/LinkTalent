package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "assignplayer")
public class AssignPlayer {
    @EmbeddedId
    private EmbeddedAssignPlayer id;

    @ElementCollection
    @CollectionTable(name = "assignplayer")
    private List<String> contractFile;

    private LocalDate endDate;

    @ManyToOne
    private Person leaderAssigned;

}
