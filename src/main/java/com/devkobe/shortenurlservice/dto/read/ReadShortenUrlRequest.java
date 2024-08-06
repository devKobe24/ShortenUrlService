package com.devkobe.shortenurlservice.dto.read;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReadShortenUrlRequest {

    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    public ShortenUrl toEntity() {
        return ShortenUrl.builder()
                         .originalUrl(originalUrl)
                         .shortenUrlKey(shortenUrlKey)
                         .build();
    }
}
