package com.sava.booksservice.controllers;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sava.booksservice.entity.Book;
import com.sava.booksservice.services.BooksService;
import com.sava.communication.data.BookDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public List<Book> getBooks() {
        return booksService.getBooks();
    }

    @GetMapping("/{bookId}")
    public BookDTO getBooksById(@PathVariable String bookId) {
        return booksService.getBookDTOById(bookId);
    }

    @PostMapping("/create-book")
    public Book createBookWithAuthor(@RequestBody Book book) throws BadRequestException {
        return booksService.createBook(book);
    }

    @PostMapping("decrease/{bookId}")
    public Boolean decreaseBook(@PathVariable String bookId) {
        return booksService.decrease(bookId);
    }
}
