package com.tarot.core.services;

import com.byuljogak.tarot.TarotServiceOuterClass.ReadTarotResponse;
import org.springframework.stereotype.Service;


@Service
public interface TarotService {
    ReadTarotResponse generateTarotReading();
}
