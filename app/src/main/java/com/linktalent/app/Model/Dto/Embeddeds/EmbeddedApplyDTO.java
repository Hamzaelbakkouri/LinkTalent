package com.linktalent.app.Model.Dto.Embeddeds;

import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Person.PlayerDtoResponse;
import com.linktalent.app.Model.Dto.Person.ProfileDtoResponse;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Parent.Person;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EmbeddedApplyDTO implements Serializable {
    private AnnouncementRequestDto announcement;
    private ProfileDtoResponse player;
}
