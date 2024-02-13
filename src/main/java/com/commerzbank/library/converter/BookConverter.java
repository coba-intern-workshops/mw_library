package com.commerzbank.library.converter;

import com.commerzbank.library.dto.BookDTO;
import com.commerzbank.library.dto.BookStatusDTO;
import com.commerzbank.library.model.Book;
import com.commerzbank.library.model.BookStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookConverter extends Converter<BookDTO, Book>{
    public BookConverter() {
        super(BookConverter::convertToEntity, BookConverter::convertToDto);
    }

    private static BookDTO convertToDto(Book book){
        return new BookDTO(book.getTitle(), book.getAuthor(), BookStatusDTO.valueOf(book.getBookStatus().toString()));
    }

    private static Book convertToEntity(BookDTO dto){
        return new Book(UUID.randomUUID(), dto.getTitle(), dto.getAuthor(), BookStatus.valueOf(dto.getBookStatus().toString()));
    }
}
