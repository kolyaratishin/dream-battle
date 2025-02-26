package com.dream.battle.service;

import com.dream.battle.model.Idea;
import com.dream.battle.model.IdeaStatus;
import com.dream.battle.repository.IdeaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdeaService {
    private final IdeaRepository ideaRepository;

    public List<Idea> getActiveIdeas() {
        return ideaRepository.findByStatus(IdeaStatus.ACTIVE);
    }

    public Optional<Idea> getIdeaById(Long id) {
        return ideaRepository.findById(id);
    }

    public Idea saveIdea(Idea idea) {
        return ideaRepository.save(idea);
    }
}
