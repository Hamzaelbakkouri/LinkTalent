package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Entity.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ApplyRepository extends JpaRepository<Apply , EmbeddedApply> {
    Page<Apply> findAllById_Player_Id(UUID id_player_id, Pageable pageable);
}
