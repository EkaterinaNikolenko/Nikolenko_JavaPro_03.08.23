package edu.hillel.springmvcresttemplate;

import edu.hillel.springmvcresttemplate.controller.NewsController;
import edu.hillel.springmvcresttemplate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringMvcRestTemplateApplication {

    @Autowired
    NewsController newsController;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringMvcRestTemplateApplication.class, args);
        NewsService newsService = run.getBean(NewsService.class);
        newsService.readNews();
        NewsController newsController = run.getBean(NewsController.class);
        newsController.printNews();
    }

}
