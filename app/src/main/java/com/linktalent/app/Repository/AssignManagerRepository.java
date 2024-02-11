package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedAssignManager;
import com.linktalent.app.Model.Entity.AssignManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignManagerRepository extends JpaRepository<AssignManager, EmbeddedAssignManager> {
}
