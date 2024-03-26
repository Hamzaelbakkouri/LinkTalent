package com.linktalent.app.Repository;

import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import com.linktalent.app.Model.Entity.Connect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectRepository extends JpaRepository<Connect, EmbeddedConnect> {
}
