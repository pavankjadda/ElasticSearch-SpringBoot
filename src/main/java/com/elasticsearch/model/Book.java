package com.elasticsearch.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "elasticdemo",type = "books")
@Data
public class Book
{
    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;

    public Book()
    {
    }

    public Book(String id, String title, String author, String releaseDate)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }


}
