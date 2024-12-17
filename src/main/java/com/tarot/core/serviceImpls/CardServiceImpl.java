package com.tarot.core.serviceImpls;

import com.byuljogak.tarot.CardServiceGrpc.CardServiceBlockingStub;
import com.byuljogak.tarot.CardServiceOuterClass.CreateCardRequest;
import com.byuljogak.tarot.CardServiceOuterClass.CreateCardResponse;
import com.tarot.core.services.CardService;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class CardServiceImpl implements CardService {

  @GrpcClient("tarot-reading-service")
  private CardServiceBlockingStub cardServiceStub;

  @Override
  public CreateCardResponse createCard(String title, String titleKr) {
    final CreateCardRequest request = CreateCardRequest.newBuilder().setTitle(title).setTitleKr(titleKr).build();
    return cardServiceStub.createCard(request);
  }

  @Override
  public void readCard(String title) {

  }

  @Override
  public void updateCard(String title, String titleKr) {

  }

  @Override
  public void deleteCard(String title) {

  }
}
