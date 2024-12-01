package com.tarot.core.services;

import com.byuljogak.tarot.CardServiceOuterClass.CreateCardResponse;

public interface CardService {
  public CreateCardResponse createCard(String title, String titleKr);
  public void readCard(String title);
  public void updateCard(String title, String titleKr);
  public void deleteCard(String title);
}
