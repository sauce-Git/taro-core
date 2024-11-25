package com.tarot.core.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarotService {
    List<String> generateKeywords();
    String generateDescription(List<String> keywords);
}
