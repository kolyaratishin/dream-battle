package com.dream.battle.service;

import com.dream.battle.dto.AuthDTO;
import com.dream.battle.dto.UserDTO;
import com.dream.battle.model.User;
import com.dream.battle.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserDTO register(AuthDTO authDTO) {
        User user = new User();
        user.setUsername(authDTO.getUsername());
        user.setEmail(authDTO.getEmail());
        user.setPassword(authDTO.getPassword());

        User savedUser = userRepository.save(user);

        return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getBalanceDrc());
    }

    public Long getBalance(Long userId) {
        return userRepository.findById(userId)
                .map(User::getBalanceDrc)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
