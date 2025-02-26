package com.dream.battle.repository;

import com.dream.battle.model.Idea;
import com.dream.battle.model.IdeaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
    List<Idea> findByStatus(IdeaStatus status);
}
