package com.elasticsearch.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.List;

@Document(indexName = "blog", type = "article")
@Data
public class Article
{
    @Id
    private String id;

    private String  title;

    @Field(type = FieldType.Nested)
    private List<Author> authors;

    public Article()
    {
    }

    public Article(String id, String title, List<Author> authors)
    {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
}
