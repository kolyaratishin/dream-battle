package com.dream.battle.controller;

import com.dream.battle.dto.IdeaDTO;
import com.dream.battle.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
@RequiredArgsConstructor
public class IdeaController {
    private final IdeaService ideaService;

    @GetMapping
    public ResponseEntity<List<IdeaDTO>> getIdeas() {
        return ResponseEntity.ok(ideaService.getActiveIdeas());
    }

    @PostMapping
    public ResponseEntity<IdeaDTO> createIdea(@RequestBody IdeaDTO ideaDTO) {
        return ResponseEntity.ok(ideaService.createIdea(ideaDTO));
    }
}
