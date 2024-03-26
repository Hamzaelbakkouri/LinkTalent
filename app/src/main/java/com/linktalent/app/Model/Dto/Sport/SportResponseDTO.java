package com.linktalent.app.Model.Dto.Sport;


import com.linktalent.app.Model.Entity.AssignTag;
import com.linktalent.app.Model.Entity.Media;
import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Model.Enums.SportCategory;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
public class SportResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private Integer numberOfPlayers;
    private List<String> rules;
    private SportCategory category;

    private List<Media> medias;
    private List<AssignTag> posts;
    private List<Team> teams;
    private List<Person> personList;
}
