package com.dream.battle.service;

import com.dream.battle.dto.TransactionDTO;
import com.dream.battle.model.Transaction;
import com.dream.battle.model.TransactionType;
import com.dream.battle.model.User;
import com.dream.battle.repository.TransactionRepository;
import com.dream.battle.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public List<TransactionDTO> getUserTransactions(Long userId) {
        return transactionRepository.findByUserId(userId).stream()
                .map(transaction -> new TransactionDTO(transaction.getId(), transaction.getType().name(), transaction.getAmount()))
                .toList();
    }

    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        User user = userRepository.findById(transactionDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = Transaction.builder()
                .user(user)
                .type(TransactionType.valueOf(transactionDTO.getType()))
                .amount(transactionDTO.getAmount())
                .build();

        Transaction savedTransaction = transactionRepository.save(transaction);

        return new TransactionDTO(savedTransaction.getUser().getId(),
                savedTransaction.getType().name(), savedTransaction.getAmount());
    }

}
