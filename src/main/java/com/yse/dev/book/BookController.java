package com.yse.dev.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yse.dev.book.dto.BookCreateDTO;
import com.yse.dev.book.service.BookService;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/create")
    public String create() {
        return "book/create";
    }

    @PostMapping("/book/create")
    public String insert(BookCreateDTO bookCreateDTO) {
        Integer bookId = this.bookService.insert(bookCreateDTO);
        return String.format("redirect:/book/read/%s", bookId);
    }

}
