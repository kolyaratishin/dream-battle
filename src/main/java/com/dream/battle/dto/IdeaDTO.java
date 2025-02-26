package com.dream.battle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String status;
    private Long userId;
}
