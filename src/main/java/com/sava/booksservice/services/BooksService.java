package com.sava.booksservice.services;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.sava.booksservice.entity.Book;
import com.sava.booksservice.repositories.BooksRepository;
import com.sava.communication.data.BookDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public List<Book> getBooks() {
        // after getting records from the repository handle them
        return booksRepository.findAll();
    }

    public Book createBook(Book book) throws BadRequestException {
        Boolean created = booksRepository.createBook(book);

        if (created == false) {
            throw new BadRequestException("problem with db");
        }

        return book;
    }

    public BookDTO getBookDTOById(String bookId) {
        return Book.toBookDTO(booksRepository.findById(bookId));
    }

    public Boolean decrease(String bookId) {
        Book book = booksRepository.findById(bookId);
        book.setQuantity(book.getQuantity() - 1);
        return booksRepository.update(book);
    }

}
