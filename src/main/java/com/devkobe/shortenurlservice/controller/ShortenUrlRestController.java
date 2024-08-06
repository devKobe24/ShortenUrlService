package com.devkobe.shortenurlservice.controller;

import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlRequest;
import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlResponse;
import com.devkobe.shortenurlservice.dto.read.ReadShortenUrlResponse;
import com.devkobe.shortenurlservice.service.SimpleShortenUrlService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShortenUrlRestController {

    private final SimpleShortenUrlService simpleShortenUrlService;

    @PostMapping("/shorten-url")
    public ResponseEntity<CreateShortenUrlResponse> createShortenUrl(@Valid @RequestBody CreateShortenUrlRequest shortenUrlRequest) {
        CreateShortenUrlResponse createShortenUrlResponse = simpleShortenUrlService.generateShortenUrl(shortenUrlRequest);
        return ResponseEntity.ok(createShortenUrlResponse);

    }

    @GetMapping("/{shortenUrlKey}")
    public ResponseEntity<?> redirectShortenUrl(@PathVariable("shortenUrlKey") String shortenUrlKey) throws URISyntaxException {
        String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);

        URI redirectUri = new URI(originalUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/shorten-url/{shortenUrlKey}")
    public ResponseEntity<ReadShortenUrlResponse> getShortenUrlInformation(@PathVariable("shortenUrlKey") String shortenUrlKey) {
        ReadShortenUrlResponse readShortenUrlResponse = simpleShortenUrlService.getShortentUrlInformationByShortenUrlKey(shortenUrlKey);
        return ResponseEntity.ok(readShortenUrlResponse);
    }
}
