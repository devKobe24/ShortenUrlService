package com.devkobe.shortenurlservice.service;

import com.devkobe.shortenurlservice.domain.ShortenUrl;
import com.devkobe.shortenurlservice.domain.exception.LackOfShortenUrlKeyException;
import com.devkobe.shortenurlservice.dto.create.CreateShortenUrlRequest;
import com.devkobe.shortenurlservice.repository.ShortenUrlRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleShortenUrlServiceUnitTest {

    @Mock
    private ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("단축 URL이 계속 중복되면 LackOfShortenUrlKeyException 예외가 발생해야한다.")
    void throwLackOfShortenUrlKeyExceptionTest() {
        CreateShortenUrlRequest createShortenUrlRequest = new CreateShortenUrlRequest(null);
        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(any())).thenReturn(new ShortenUrl(null, null));

        Assertions.assertThrows(LackOfShortenUrlKeyException.class, () -> {
            simpleShortenUrlService.generateShortenUrl(createShortenUrlRequest);
        });
    }
}
