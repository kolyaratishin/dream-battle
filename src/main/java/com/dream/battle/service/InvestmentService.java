package com.dream.battle.service;

import com.dream.battle.dto.InvestmentDTO;
import com.dream.battle.model.Battle;
import com.dream.battle.model.Idea;
import com.dream.battle.model.Investment;
import com.dream.battle.model.User;
import com.dream.battle.repository.BattleRepository;
import com.dream.battle.repository.IdeaRepository;
import com.dream.battle.repository.InvestmentRepository;
import com.dream.battle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;
    private final BattleRepository battleRepository;

    public InvestmentDTO invest(InvestmentDTO investmentDTO) {
        User user = userRepository.findById(investmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Idea idea = ideaRepository.findById(investmentDTO.getIdeaId())
                .orElseThrow(() -> new RuntimeException("Idea not found"));

        Battle battle = battleRepository.findById(investmentDTO.getBattleId())
                .orElseThrow(() -> new RuntimeException("Battle not found"));

        Investment investment = Investment.builder()
                .user(user)
                .idea(idea)
                .battle(battle)
                .amountDrc(investmentDTO.getAmountDrc())
                .build();

        Investment savedInvestment = investmentRepository.save(investment);

        return new InvestmentDTO(
                savedInvestment.getUser().getId(),
                savedInvestment.getIdea().getId(),
                savedInvestment.getBattle().getId(),
                savedInvestment.getAmountDrc()
        );
    }

    public List<InvestmentDTO> getUserInvestments(Long userId) {
        return investmentRepository.findByUserId(userId).stream()
                .map(investment -> new InvestmentDTO(
                        investment.getUser().getId(),
                        investment.getIdea().getId(),
                        investment.getBattle().getId(),
                        investment.getAmountDrc()
                ))
                .collect(Collectors.toList());
    }
}
