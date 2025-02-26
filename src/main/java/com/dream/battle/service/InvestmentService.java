package com.dream.battle.service;

import com.dream.battle.model.Investment;
import com.dream.battle.repository.InvestmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvestmentService {
    private final InvestmentRepository investmentRepository;

    public List<Investment> getInvestmentsByBattle(Long battleId) {
        return investmentRepository.findByBattleId(battleId);
    }

    public List<Investment> getInvestmentsByUser(Long userId) {
        return investmentRepository.findByUserId(userId);
    }

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }
}
