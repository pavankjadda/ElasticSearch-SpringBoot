package com.elasticsearch.model;

import lombok.Data;

@Data
public class Author
{
    private String  name;

    public Author()
    {

    }
    public Author(String name)
    {
        this.name = name;
    }
}
