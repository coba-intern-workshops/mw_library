package com.commerzbank.library.test;

import com.commerzbank.library.book.BookRepository;
import com.commerzbank.library.book.BookRepositoryImpl;
import com.commerzbank.library.model.Book;
import com.commerzbank.library.model.BookStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class BookRepositoryImplTest {
    private BookRepository repository = new BookRepositoryImpl();

    @BeforeEach
    void setUp() {
        repository = new BookRepositoryImpl();
    }

    @Test
    void shouldReturnEmptyListForNoElementsOnList() {
        assertNotNull(repository.getAll());

        int EMPTY_LIST_SIZE = 0;
        assertEquals(EMPTY_LIST_SIZE, repository.getAll().size());
    }

    @Test
    void shouldAddBookToList() {
        Book book = new Book(UUID.randomUUID(), "testTitle", "testAuthor", BookStatus.AVAILABLE);

        repository.create(book);

        assertNotNull(repository.getAll());

        int EXPECTED_LIST_SIZE_WHEN_ADD = 1;
        assertEquals(EXPECTED_LIST_SIZE_WHEN_ADD, repository.getAll().size());
    }

    @Test
    void shouldCreatedObjectBeSameAsSend() {
        Book book = new Book(UUID.randomUUID(),"testTitle", "testAuthor", BookStatus.AVAILABLE);

        Book bookFromRepository = repository.create(book);

        assertEquals(book, bookFromRepository);
    }
}
