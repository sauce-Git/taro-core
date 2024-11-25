package com.tarot.core.dto.gpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromptRequestDto {
    private String model;
    private List<Message> messages;
    private float temperature;
    private int maxTokens;
    private int topP;
    private int frequencyPenalty;
    private int presencePenalty;

    public PromptRequestDto(String model, List<Message> messages, float temperature, int maxTokens, int topP, int frequencyPenalty, int presencePenalty) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
    }
}
