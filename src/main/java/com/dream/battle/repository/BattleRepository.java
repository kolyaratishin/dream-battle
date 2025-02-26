package com.dream.battle.repository;

import com.dream.battle.model.Battle;
import com.dream.battle.model.BattleStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepository extends JpaRepository<Battle, Long> {
    Optional<Battle> findByStatus(BattleStatus status);
}
