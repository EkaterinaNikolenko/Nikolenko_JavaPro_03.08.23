package edu.hillel.springmvcresttemplate.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class NewsClientTest {
    @Autowired
    private NewsClient newsClient;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void getNewsTest() {
        List<String> newsList = Arrays.asList("News 1", "News 2");
        ResponseEntity<List<String>> responseEntity = new ResponseEntity<>(newsList, HttpStatus.OK);

        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(),
                any(ParameterizedTypeReference.class)
        )).thenReturn(responseEntity);

        List<String> result = newsClient.getNews();

        assertEquals(newsList, result);
    }
}