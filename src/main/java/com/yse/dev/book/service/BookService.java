package com.yse.dev.book.service;

import org.springframework.stereotype.Service;

import com.yse.dev.book.dto.BookCreateDTO;
import com.yse.dev.book.entity.Book;
import com.yse.dev.book.entity.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer insert(BookCreateDTO bookCreateDTO) {
        Book book = new Book(bookCreateDTO.getTitle(), bookCreateDTO.getPrice());
        this.bookRepository.save(book);

        return book.getBookId();
    }

}
