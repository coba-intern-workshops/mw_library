package com.commerzbank.library.repository;

import com.commerzbank.library.model.Book;
import com.commerzbank.library.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements Repository<Book> {
    static final List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public Book save(Book book) {
        bookList.add(book);
        return book;
    }
}
