package com.tarot.core.serviceImpls;

import com.byuljogak.tarot.TarotServiceGrpc.TarotServiceBlockingStub;
import com.byuljogak.tarot.TarotServiceOuterClass.ReadTarotRequest;
import com.byuljogak.tarot.TarotServiceOuterClass.ReadTarotResponse;
import com.tarot.core.services.TarotService;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TarotServiceImpl implements TarotService {

  @GrpcClient("tarot-reading-service")
  private TarotServiceBlockingStub tarotServiceStub;

  @Override
  public ReadTarotResponse generateTarotReading() {
    return this.tarotServiceStub.readTarot(ReadTarotRequest.newBuilder().build());
  }
}
