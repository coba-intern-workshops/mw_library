package com.commerzbank.library.service;

import com.commerzbank.library.converter.BookConverter;
import com.commerzbank.library.dto.BookDTO;
import com.commerzbank.library.model.Book;
import com.commerzbank.library.repository.BookRepositoryImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryImpl bookRepository;
    private final BookConverter bookConverter;

    public List<Book> findBooks(SearchCriteria searchCriteria) {
        return  bookRepository.findAll().stream()
                .filter(book -> book.getAuthor().contains(searchCriteria.getAuthor()))
                .toList();
    }

    public BookDTO saveBook(BookDTO bookDto){
        var result = bookRepository.save(bookConverter.convertFromDto(bookDto));
        return bookConverter.convertFromEntity(result);
    }
}
