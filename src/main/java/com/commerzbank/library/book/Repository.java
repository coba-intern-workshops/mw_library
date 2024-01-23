package com.commerzbank.library.book;

import com.commerzbank.library.model.Book;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T save(T object);
}
