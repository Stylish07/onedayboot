package com.yse.dev.book.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yse.dev.book.dto.BookCreateDTO;
import com.yse.dev.book.dto.BookEditResponseDTO;
import com.yse.dev.book.dto.BookReadResponseDTO;
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
        Integer bookId = bookService.insert(bookCreateDTO);

        return String.format("redirect:/book/read/%s", bookId);
    }

    @GetMapping("/book/read/{bookId}")
    public ModelAndView read(@PathVariable Integer bookId) {
        BookReadResponseDTO bookReadResponseDTO = this.bookService.read(bookId);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bookReadResponseDTO", bookReadResponseDTO);
        mav.setViewName("book/read");

        return mav;
    }

    @GetMapping("/book/edit/{bookId}")
    public ModelAndView edit(@PathVariable Integer bookId) {
        BookEditResponseDTO bookEditResponseDTO = bookService.edit(bookId);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bookEditResponseDTO", bookEditResponseDTO);
        mav.setViewName("book/edit");

        return mav;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView noSuchElementExceptionHandler(NoSuchElementException ex) {
        ModelAndView mav = new ModelAndView();
        mav.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        mav.addObject("message", "책 정보가 없습니다.");
        mav.addObject("location", "/book/list");
        mav.setViewName("common/error/422");

        return mav;
    }

}
