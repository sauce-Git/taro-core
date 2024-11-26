package com.tarot.core.controllers;

import com.tarot.core.dto.gpt.TarotServiceResponseDto;
import com.tarot.core.services.TarotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tarot")
@RequiredArgsConstructor
public class TarotController {
    private final TarotService tarotService;

    @GetMapping("/execute")
    public ResponseEntity<TarotServiceResponseDto> executeTarotReading() {
        Date birthday = new Date();

        List<String> models = tarotService.generateKeywords();
        String description = tarotService.generateDescription(models);

        TarotServiceResponseDto response = new TarotServiceResponseDto(
                models,
                description
        );

        return ResponseEntity.ok(response);
    }
}
