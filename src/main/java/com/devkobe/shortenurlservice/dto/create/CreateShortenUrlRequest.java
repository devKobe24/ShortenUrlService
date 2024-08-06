package com.devkobe.shortenurlservice.dto.create;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateShortenUrlRequest {

    @URL(message = "Invalid URL format")
    private String originalUrl;

    public ShortenUrl toEntity() {
        return ShortenUrl.builder()
                         .originalUrl(originalUrl)
                         .build();
    }
}
