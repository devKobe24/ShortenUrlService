package com.devkobe.shortenurlservice.service;

import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlRequest;
import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleShortenUrlServiceTest {

    @Autowired
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("URL을 단축한 후 단축된 URL 키로 조회하면 원래 URL이 조회되어야 한다.")
    void shortenUrlAddTest() {
        String expectedOriginalUrl = "https://www.google.com";
        CreateShortenUrlRequest shortenUrlRequest = new CreateShortenUrlRequest(expectedOriginalUrl);

        CreateShortenUrlResponse createShortenUrlResponse = simpleShortenUrlService.generateShortenUrl(shortenUrlRequest);

        String shortenUrlKey = createShortenUrlResponse.getShortenUrlKey();

        String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);

        assertThat(originalUrl.equals(expectedOriginalUrl));
    }
}