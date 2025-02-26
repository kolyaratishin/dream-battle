package com.dream.battle.controller;

import com.dream.battle.dto.BattleDTO;
import com.dream.battle.service.BattleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/battles")
@RequiredArgsConstructor
public class BattleController {
    private final BattleService battleService;

    @GetMapping("/current")
    public ResponseEntity<BattleDTO> getActiveBattle() {
        return ResponseEntity.ok(battleService.getActiveBattle());
    }
}
