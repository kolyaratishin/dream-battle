package com.dream.battle.service;

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

    public Optional<Battle> getActiveBattle() {
        return battleRepository.findByStatus(BattleStatus.ACTIVE);
    }

    public Battle saveBattle(Battle battle) {
        return battleRepository.save(battle);
    }
}
