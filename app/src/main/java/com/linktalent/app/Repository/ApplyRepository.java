package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedApply;
import com.linktalent.app.Model.Entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplyRepository extends JpaRepository<Apply , EmbeddedApply> {
}
