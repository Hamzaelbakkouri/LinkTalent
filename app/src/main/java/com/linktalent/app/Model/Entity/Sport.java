package com.linktalent.app.Model.Entity;

import com.linktalent.app.Model.Entity.Parent.Person;
import com.linktalent.app.Model.Enums.SportCategory;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity()
public final class Sport {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique = true)
    private String name;

    private String description;

    private Integer numberOfPlayers;

    @ElementCollection
    @CollectionTable(name = "Sport")
    private List<String> rules;

    @Enumerated(EnumType.STRING)
    private SportCategory category;

    @OneToMany(mappedBy = "sport")
    private List<Media> medias;

    @OneToMany(mappedBy = "sport")
    private List<AssignTag> posts;

    @OneToMany(mappedBy = "sport")
    private List<Team> teams;

    @OneToMany(mappedBy = "sport")
    private List<Person> personList;
}
