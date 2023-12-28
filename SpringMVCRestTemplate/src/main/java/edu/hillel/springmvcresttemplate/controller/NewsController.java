package edu.hillel.springmvcresttemplate.controller;

import edu.hillel.springmvcresttemplate.service.NewsClient;
import edu.hillel.springmvcresttemplate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsClient newsClient;

    @GetMapping("/news")
    public List<String> getNews() {
        return newsService.getProcessedNews();
    }

    @GetMapping("/printNews")
    public void printNews() {
        System.out.println(newsClient.getNews());
    }

}
