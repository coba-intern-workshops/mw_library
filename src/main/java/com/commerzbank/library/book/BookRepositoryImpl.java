package com.commerzbank.library.book;

import com.commerzbank.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    static final List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    @Override
    public Book create(Book book) {
        bookList.add(book);
        return book;
    }
}
