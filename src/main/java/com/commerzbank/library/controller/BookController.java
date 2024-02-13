package com.commerzbank.library.controller;

import com.commerzbank.library.dto.BookDTO;
import com.commerzbank.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

//    @GetMapping("/books")
//    public ResponseEntity<List<BookDTO>> findAllBooks(){
//        return ResponseEntity.ok(bookService.findAllBooks());
//    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDto){
        return ResponseEntity.ok(bookService.saveBook(bookDto));
    }
}