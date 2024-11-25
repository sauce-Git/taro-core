package com.tarot.core.dto.gpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarotServiceResponseDto {
    private List<String> keywords;
    private String description;
}
