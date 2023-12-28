package edu.hillel.springmvcresttemplate.service;

        import com.kwabenaberko.newsapilib.NewsApiClient;
        import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
        import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
        import edu.hillel.springmvcresttemplate.config.Config;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private Config config;

    private List<String> processedNews = new ArrayList<>();

    public void readNews() {
        NewsApiClient newsApiClient = new NewsApiClient(config.apiNewsKey);
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        List<String> articles = response.getArticles().stream().map(article -> "Glory to Ukraine! " + article.getTitle() + "\n").collect(Collectors.toList());
//                        System.out.println(articles);
                        processedNews.addAll(articles);
//                        System.out.println(response.getArticles().get(0).getTitle());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    public List<String> getProcessedNews() {
        return processedNews;
    }
}
