package com.yse.dev.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(length = 200)
    private String title;

    private Integer price;

    @CreationTimestamp
    private LocalDateTime insertDateTime;

    /**
     * JpaRepository가 Reflection을 사용하므로 기본생성자가 필요.<br>
     * 빈 객체 생성을 막기위해 private으로 설정.(Reflection 사용과 무관함)
     */
    private Book() {
    }

    public Book(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

}
