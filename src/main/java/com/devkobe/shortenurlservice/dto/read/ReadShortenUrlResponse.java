package com.devkobe.shortenurlservice.dto.read;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import lombok.Getter;

@Getter
public class ReadShortenUrlResponse {

    private final String originalUrl;
    private final String shortenUrlKey;
    private final Long redirectCount;

    public ReadShortenUrlResponse(ShortenUrl shortenUrl) {
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenUrlKey();
        this.redirectCount = shortenUrl.getRedirectCount();
    }
}
