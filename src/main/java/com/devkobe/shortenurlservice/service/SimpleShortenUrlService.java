package com.devkobe.shortenurlservice.service;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import com.devkobe.shortenurlservice.domain.exception.LackOfShortenUrlKeyException;
import com.devkobe.shortenurlservice.domain.exception.NotFoundShortenUrlException;
import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlRequest;
import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlResponse;
import com.devkobe.shortenurlservice.dto.read.ReadShortenUrlResponse;
import com.devkobe.shortenurlservice.repository.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SimpleShortenUrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    // Shorten URL Generate
    public CreateShortenUrlResponse generateShortenUrl(CreateShortenUrlRequest createShortenUrlRequest) {
        String originalUrl = createShortenUrlRequest.getOriginalUrl();
        String shortenUrlKey = getUniqueShortenUrlKey();

        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        CreateShortenUrlResponse createShortenUrlResponse = new CreateShortenUrlResponse(shortenUrl);

        return createShortenUrlResponse;
    }

    // Get Original URL By Shorten URL KEY
    public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }
        shortenUrl.increaseRedirectCount();
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        String originalUrl = shortenUrl.getOriginalUrl();

        return originalUrl;
    }

    // Get Shorten URL Information By Shorten URL KEY
    public ReadShortenUrlResponse getShortentUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }

        ReadShortenUrlResponse readShortenUrlResponse = new ReadShortenUrlResponse(shortenUrl);

        return readShortenUrlResponse;
    }

    // Get Unique Shorten URL KEY
    private String getUniqueShortenUrlKey() {
        final int MAX_RETRY_COUNT = 5;
        int count = 0;

        while (count++ < MAX_RETRY_COUNT) {
            String shortenUrlKey = ShortenUrl.generateShortenUrlKey();
            ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

            if (null == shortenUrl) {
                return shortenUrlKey;
            }
        }
        throw new LackOfShortenUrlKeyException();
    }
}
