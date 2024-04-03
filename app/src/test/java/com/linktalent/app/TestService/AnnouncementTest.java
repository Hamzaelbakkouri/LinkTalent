package com.linktalent.app.TestService;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementRequestDto;
import com.linktalent.app.Model.Dto.Announecement.AnnouncementResponseDto;
import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Team;
import com.linktalent.app.Repository.AnnouncementRepository;
import com.linktalent.app.Repository.TeamRepository;
import com.linktalent.app.Services.Implementation.AnnouncementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnnouncementTest {

    @Mock
    private AnnouncementRepository announcementRepository;

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AnnouncementServiceImpl announcementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() {
        UUID announcementId = UUID.randomUUID();
        Announcement announcement = new Announcement();
        when(announcementRepository.findById(announcementId)).thenReturn(Optional.of(announcement));

        AnnouncementResponseDto responseDto = new AnnouncementResponseDto();
        when(modelMapper.map(announcement, AnnouncementResponseDto.class)).thenReturn(responseDto);

        Optional<AnnouncementResponseDto> result = announcementService.getById(announcementId);

        assertTrue(result.isPresent());
        assertEquals(responseDto, result.get());
    }

    @Test
    public void testDelete() {
        AnnouncementRequestDto requestDto = new AnnouncementRequestDto();
        UUID announcementId = UUID.randomUUID();
        requestDto.setId(announcementId);

        when(announcementRepository.findById(announcementId)).thenReturn(Optional.of(new Announcement()));

        assertTrue(announcementService.delete(requestDto));
    }

    @Test
    public void testFindAllByTeam() {
        Team team = new Team();
        UUID teamId = UUID.randomUUID();
        team.setId(teamId);
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));

        Announcement announcement = new Announcement();
        Page<Announcement> announcementPage = new PageImpl<>(Collections.singletonList(announcement));
        when(announcementRepository.findAllByTeam(team, Pageable.unpaged())).thenReturn(announcementPage);

        AnnouncementResponseDto responseDto = new AnnouncementResponseDto();
        when(modelMapper.map(announcement, AnnouncementResponseDto.class)).thenReturn(responseDto);

        Page<AnnouncementResponseDto> result = announcementService.findAllByTeam(team, Pageable.unpaged());

        assertEquals(1, result.getContent().size());
        assertEquals(responseDto, result.getContent().get(0));
    }

    @Test
    public void testGetRandomAnnouncement() {
        Announcement announcement = new Announcement();
        Page<Announcement> announcementPage = new PageImpl<>(Collections.singletonList(announcement));
        when(announcementRepository.findRandomQuestions(any(Pageable.class))).thenReturn(announcementPage);

        AnnouncementResponseDto responseDto = new AnnouncementResponseDto();
        when(modelMapper.map(announcement, AnnouncementResponseDto.class)).thenReturn(responseDto);

        Page<AnnouncementResponseDto> result = announcementService.getRandomAnnouncement(Pageable.unpaged());

        assertEquals(1, result.getContent().size());
        assertEquals(responseDto, result.getContent().get(0));
    }
}

