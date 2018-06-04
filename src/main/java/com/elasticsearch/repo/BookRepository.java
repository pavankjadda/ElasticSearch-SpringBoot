package com.elasticsearch.repo;

import com.elasticsearch.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,String>
{
    @Override
    Page<Book> findAll(Pageable pageable);

    Page<Book>  findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);
}
