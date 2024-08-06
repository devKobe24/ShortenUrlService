package com.devkobe.shortenurlservice.dto.create;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import lombok.Getter;

@Getter
public class CreateShortenUrlResponse {

    private final String originalUrl;
    private final String shortenUrlKey;

    public CreateShortenUrlResponse(ShortenUrl shortenUrl) {
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenUrlKey();
    }
}
