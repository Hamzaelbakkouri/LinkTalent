package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.AssignTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTagRepository extends JpaRepository<AssignTag , Integer> {
}
