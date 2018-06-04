package com.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
@Slf4j
public class ArticleServiceTest
{
    @Autowired
    private ArticleServiceImpl  articleService;

    @Autowired
    private ElasticsearchTemplate   elasticsearchTemplate;

    @Before
    public void setUp()
    {
        elasticsearchTemplate.deleteIndex(Article.class);
        elasticsearchTemplate.createIndex(Article.class);
        elasticsearchTemplate.putMapping(Article.class);
        elasticsearchTemplate.refresh(Article.class);
    }

    @Test
    public void testSave()
    {
        Article article=new Article("1001","GoogleIO 2018", Arrays.asList(new Author("John Dew"),new Author("Chris Rocker")));
        Article returnedArticle=articleService.save(article);
        log.info("returnedArticle.id -> {}, returnedArticle.title-> {}",returnedArticle.getId(),returnedArticle.getTitle());
    }
}
