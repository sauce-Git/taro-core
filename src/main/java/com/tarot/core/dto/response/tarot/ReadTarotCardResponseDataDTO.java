package com.tarot.core.dto.response.tarot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReadTarotResponseDataDTO {

  private String title;
  private String titleKR;
  private String[] keywords;
  private String advice;
}
