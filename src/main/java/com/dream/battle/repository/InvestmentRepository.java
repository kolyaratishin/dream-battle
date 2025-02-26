package com.dream.battle.repository;


import com.dream.battle.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByBattleId(Long battleId);
    List<Investment> findByUserId(Long userId);
}
