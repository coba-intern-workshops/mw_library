package com.commerzbank.library.book;

import com.commerzbank.library.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findBooks(SearchCriteria searchCriteria) {
        return  bookRepository.getAll().stream()
                .filter(book -> book.getAuthor().contains(searchCriteria.getAuthor()))
                .toList();
    }


}
