package com.dream.battle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleDTO {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long winnerIdeaId;
    private String status;
}
