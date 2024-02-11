package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedAssignAdmin;
import com.linktalent.app.Model.Entity.AssignAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignAdminRepository extends JpaRepository<AssignAdmin, EmbeddedAssignAdmin> {
}
