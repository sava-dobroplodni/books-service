package com.sava.booksservice.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sava.booksservice.entity.Book;

@Service
public class BooksRepository {
    private List<Book> books = new ArrayList<>();

    public BooksRepository() {
        books.add(new Book("SwXnCSkZP7IhgPYmLs53U", "Donki hot", 5));
        books.add(new Book("vriqEY-T23ztxhPubjYmW", "The pact", 1));
        books.add(new Book("pXMfCmCNutD2aEj-Mh0IV", "Minecraft book", 7));
    }

    public List<Book> findAll() {
        return books;
    }

    public Boolean createBook(Book book) {
        books.add(book);
        return true;
    }

    public Boolean update(Book book) {
        this.books.removeIf(b -> b.getId().equals(book.getId()));
        this.books.add(book);
        return true;
    }

    public Book findById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
