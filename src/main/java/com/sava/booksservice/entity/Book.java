package com.sava.booksservice.entity;

import com.sava.communication.data.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private int quantity;

    public static BookDTO toBookDTO(Book book) {
        return BookDTO.builder()//
                .id(book.getId())
                .name(book.getName())//
                .quantity(book.getQuantity())
                .build();
    }
}
