package com.dream.battle.controller;

import com.dream.battle.dto.InvestmentDTO;
import com.dream.battle.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
@RequiredArgsConstructor
public class InvestmentController {
    private final InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<InvestmentDTO> invest(@RequestBody InvestmentDTO investmentDTO) {
        return ResponseEntity.ok(investmentService.invest(investmentDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<InvestmentDTO>> getUserInvestments(@PathVariable Long userId) {
        return ResponseEntity.ok(investmentService.getUserInvestments(userId));
    }
}
