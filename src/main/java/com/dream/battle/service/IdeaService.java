package com.dream.battle.service;

import com.dream.battle.dto.IdeaDTO;
import com.dream.battle.model.Idea;
import com.dream.battle.model.IdeaStatus;
import com.dream.battle.model.User;
import com.dream.battle.repository.IdeaRepository;
import com.dream.battle.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdeaService {
    private final IdeaRepository ideaRepository;
    private final UserRepository userRepository;

    public List<IdeaDTO> getActiveIdeas() {
        return ideaRepository.findByStatus(IdeaStatus.ACTIVE).stream()
                .map(idea -> new IdeaDTO(idea.getId(), idea.getTitle(), idea.getDescription(), idea.getImageUrl(), idea.getImageUrl(), idea.getUser().getId()))
                .toList();
    }

    public Optional<Idea> getIdeaById(Long id) {
        return ideaRepository.findById(id);
    }

    public IdeaDTO createIdea(IdeaDTO ideaDTO) {
        User user = userRepository.findById(ideaDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Idea idea = Idea.builder()
                .title(ideaDTO.getTitle())
                .description(ideaDTO.getDescription())
                .imageUrl(ideaDTO.getImageUrl())
                .status(IdeaStatus.ACTIVE)
                .user(user)
                .build();

        Idea savedIdea = ideaRepository.save(idea);

        return new IdeaDTO(savedIdea.getId(), savedIdea.getTitle(), savedIdea.getDescription(),
                savedIdea.getImageUrl(), savedIdea.getStatus().name(), savedIdea.getUser().getId());
    }

}
