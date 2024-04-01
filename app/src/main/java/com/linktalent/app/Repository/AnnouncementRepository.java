package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Announcement;
import com.linktalent.app.Model.Entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement , UUID> {
    Page<Announcement> findAllByTeam(Team team, Pageable pageable);

    @Query(value = "SELECT an FROM Announcement an ORDER BY RAND()",
            countQuery = "SELECT COUNT(*) FROM Announcement",
            nativeQuery = true)
    Page<Announcement> findRandomQuestions(Pageable pageable);
}
