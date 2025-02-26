package com.dream.battle.service;

import com.dream.battle.dto.BattleDTO;
import com.dream.battle.model.Battle;
import com.dream.battle.model.BattleStatus;
import com.dream.battle.repository.BattleRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BattleService {
    private final BattleRepository battleRepository;

    public BattleDTO getActiveBattle() {
        Battle battle = battleRepository.findByStatus(BattleStatus.ACTIVE)
                .orElseThrow(() -> new RuntimeException("No active battle found"));

        return new BattleDTO(battle.getId(), battle.getStartDate(), battle.getEndDate(),
                battle.getWinnerIdea() != null ? battle.getWinnerIdea().getId() : null, battle.getStatus().name());
    }

    public Battle saveBattle(Battle battle) {
        return battleRepository.save(battle);
    }
}
