package com.dream.battle.controller;

import com.dream.battle.dto.UserDTO;
import com.dream.battle.dto.TransactionDTO;
import com.dream.battle.service.TransactionService;
import com.dream.battle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TransactionService transactionService;

    @GetMapping("/{userId}/balance")
    public ResponseEntity<Long> getBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getBalance(userId));
    }

    @GetMapping("/{userId}/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transactionService.getUserTransactions(userId));
    }
}
