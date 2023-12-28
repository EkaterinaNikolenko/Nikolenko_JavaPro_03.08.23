package edu.hillel.springmvcresttemplate.controller;

import edu.hillel.springmvcresttemplate.service.NewsClient;
import edu.hillel.springmvcresttemplate.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class NewsControllerTest {
    @Autowired
    private NewsController newsController;

    @MockBean
    private NewsService newsService;

    @MockBean
    private NewsClient newsClient;

    @Test
    public void getNewsTest() {
        List<String> newsList = Arrays.asList("News 1", "News 2");
        when(newsService.getProcessedNews()).thenReturn(newsList);

        List<String> result = newsController.getNews();

        assertEquals(newsList, result);
    }

    @Test
    public void printNewsTest() {
        List<String> newsList = Arrays.asList("News 1", "News 2");
        when(newsClient.getNews()).thenReturn(newsList);

        newsController.printNews();

        verify(newsClient, times(1)).getNews();
    }

}