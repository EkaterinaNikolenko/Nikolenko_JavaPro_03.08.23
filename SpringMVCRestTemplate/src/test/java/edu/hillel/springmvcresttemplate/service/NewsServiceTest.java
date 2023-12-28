package edu.hillel.springmvcresttemplate.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import edu.hillel.springmvcresttemplate.config.Config;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class NewsServiceTest {
    @SpyBean
    private NewsService newsService;

    @Test
    public void getProcessedNewsTest() {
        List<String> newsList = Arrays.asList("News 1", "News 2");
        doReturn(newsList).when(newsService).getProcessedNews();

        List<String> result = newsService.getProcessedNews();

        assertEquals(newsList, result);
    }

    @Test
    public void readNewsTest() {
        List<String> newsList = Arrays.asList("News 1", "News 2");
        NewsApiClient newsApiClient = mock(NewsApiClient.class);
        doAnswer(invocation -> {
            NewsApiClient.ArticlesResponseCallback callback = invocation.getArgument(1);
            ArticleResponse response = new ArticleResponse();
            response.setArticles(newsList.stream().map(title -> {
                Article article = new Article();
                article.setTitle(title);
                return article;
            }).collect(Collectors.toList()));
            callback.onSuccess(response);
            return null;
        }).when(newsApiClient).getTopHeadlines(any(), any());

        newsService.readNews();

        List<String> processedNews = newsService.getProcessedNews();
        assertTrue(processedNews.stream().allMatch(news -> news.startsWith("Glory to Ukraine! ")));
    }
}