package com.tarot.core.serviceImpls;

import com.tarot.core.config.GPTConfig;
import com.tarot.core.dto.gpt.Message;
import com.tarot.core.dto.gpt.PromptRequestDto;
import com.tarot.core.dto.gpt.PromptResponseDto;
import com.tarot.core.services.TarotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TarotServiceImpl implements TarotService {

    private final GPTConfig gptConfig;
    private final RestTemplate restTemplate;

    private PromptResponseDto query(List<Message> messages) {
        UriComponents endpoint =
                UriComponentsBuilder.fromUriString(gptConfig.getApiBase()).path("/chat/completions").build();

        PromptRequestDto promptRequestDto = new PromptRequestDto(gptConfig.getModel(), messages, 1,
                                                                 gptConfig.getMaxTokens(), 1, 2, 2);

        return restTemplate.postForObject(endpoint.toUriString(), promptRequestDto, PromptResponseDto.class);
    }

    @Override
    public List<String> generateKeywords() {
        Message keywordSetupMessage = new Message("system",
                                                  "If generate word is given, make tarot keywords in korean. Separate them with comma like 공정함, 균형, 진실, 책임, 법적 문제'. Count of keywords should be between 3 and 5.");
        Message keywordQueryMessage = new Message("user", "generate");
        List<Message> messages = Arrays.asList(keywordSetupMessage, keywordQueryMessage);

        // Query the GPT-3 API
        PromptResponseDto promptResponseDto = query(messages);

        // Parse the response and crop empty characters
        return Arrays.stream(promptResponseDto.getChoices().getFirst().getMessage().getContent().split(","))
                     .map(String::trim)
                     .toList();
    }

    @Override
    public String generateDescription(List<String> keywords) {
        String keywordString = String.join(", ", keywords);
        Message descriptionSetupMessage = new Message("system",
                                                      "You have to make tarot description for close future with the keywords in korean. Minimum 512 maximum length of 1024 characters.");
        Message descriptionQueryMessage = new Message("user", keywordString);
        List<Message> messages = Arrays.asList(descriptionSetupMessage, descriptionQueryMessage);

        // Query the GPT-3 API
        PromptResponseDto promptResponseDto = query(messages);

        if (Objects.isNull(promptResponseDto)) {
            return "Failed to get response from GPT-3";
        } else {
            return promptResponseDto.getChoices().getFirst().getMessage().getContent();
        }
    }

}
