package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedAssignPlayer;
import com.linktalent.app.Model.Entity.AssignPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignPlayerRepository extends JpaRepository<AssignPlayer, EmbeddedAssignPlayer> {
}
