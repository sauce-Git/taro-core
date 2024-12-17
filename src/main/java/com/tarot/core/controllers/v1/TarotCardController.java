package com.tarot.core.controllers.v1;

import com.tarot.core.dto.response.CustomResponseDTO;
import com.tarot.core.dto.response.tarot.ReadTarotCardResponseDataDTO;
import com.tarot.core.services.TarotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byuljogak.tarot.TarotServiceOuterClass.ReadTarotResponse;

@RestController
@RequestMapping("/v1/card")
@RequiredArgsConstructor
public class TarotCardController {

  private final TarotService tarotService;

  @GetMapping("/read")
  public ResponseEntity<CustomResponseDTO<ReadTarotCardResponseDataDTO>> readTarotCard() {
    final ReadTarotResponse readTarotResponse = this.tarotService.generateTarotReading();
    final ReadTarotCardResponseDataDTO readTarotCardResponse = ReadTarotCardResponseDataDTO.builder()
        .title(readTarotResponse.getCard().getTitle())
        .titleKR(readTarotResponse.getCard().getTitleKr())
        .keywords(readTarotResponse.getCardContents().getKeywordsList().toArray(new String[0]))
        .advice(readTarotResponse.getCardContents().getAdvice())
        .build();

    final CustomResponseDTO<ReadTarotCardResponseDataDTO> response = CustomResponseDTO.<ReadTarotCardResponseDataDTO>builder()
        .message("Tarot reading has been generated successfully.")
        .data(readTarotCardResponse)
        .build();

    return ResponseEntity.ok(response);
  }
}
