package com.linktalent.app.Repository;

import com.linktalent.app.Model.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media , Integer> {
}
