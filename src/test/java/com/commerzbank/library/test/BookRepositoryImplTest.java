package com.commerzbank.library.test;

import com.commerzbank.library.repository.BookRepositoryImpl;
import com.commerzbank.library.model.Book;
import com.commerzbank.library.model.BookStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class BookRepositoryImplTest {
    private BookRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepositoryImpl();
    }

    @Test
    void shouldReturnEmptyListForNoElementsOnList() {
        assertNotNull(repository.findAll());

        int EMPTY_LIST_SIZE = 0;
        assertEquals(EMPTY_LIST_SIZE, repository.findAll().size());
    }

    @Test
    void shouldAddBookToList() {
        Book book = new Book(UUID.randomUUID(), "testTitle", "testAuthor", BookStatus.AVAILABLE);

        repository.save(book);

        assertNotNull(repository.findAll());

        int EXPECTED_LIST_SIZE_WHEN_ADD = 1;
        assertEquals(EXPECTED_LIST_SIZE_WHEN_ADD, repository.findAll().size());
    }

    @Test
    void shouldCreatedObjectBeSameAsSend() {
        Book book = new Book(UUID.randomUUID(),"testTitle", "testAuthor", BookStatus.AVAILABLE);

        Book bookFromRepository = repository.save(book);

        assertEquals(book, bookFromRepository);
    }
}
