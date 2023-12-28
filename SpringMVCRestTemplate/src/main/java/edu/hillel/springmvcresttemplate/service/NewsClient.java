package edu.hillel.springmvcresttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsClient {
    @Autowired
    private RestTemplate restTemplate;

    public List<String> getNews() {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                "http://localhost:8080/news",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {});

        return response.getBody();
    }
}
