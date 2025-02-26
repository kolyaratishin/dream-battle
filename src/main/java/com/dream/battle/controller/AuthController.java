package com.dream.battle.controller;

import com.dream.battle.dto.AuthDTO;
import com.dream.battle.dto.UserDTO;
import com.dream.battle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(userService.register(authDTO));
    }
}
