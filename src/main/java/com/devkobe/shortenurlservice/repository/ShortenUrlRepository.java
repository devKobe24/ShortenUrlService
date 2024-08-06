package com.devkobe.shortenurlservice.repository;

import com.devkobe.shortenurlservice.domain.ShortenUrl;

public interface ShortenUrlRepository {
    void saveShortenUrl(ShortenUrl shortenUrl);
    ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
}
