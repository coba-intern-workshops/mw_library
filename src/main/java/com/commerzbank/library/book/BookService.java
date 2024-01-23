package com.commerzbank.library.book;

import com.commerzbank.library.model.Book;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryImpl repository;

    public List<Book> findBooks(SearchCriteria searchCriteria) {
        return  repository.findAll().stream()
                .filter(book -> book.getAuthor().contains(searchCriteria.getAuthor()))
                .toList();
    }


}
