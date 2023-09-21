package com.yse.dev.book.dto;

public class BookCreateDTO {

    private String title;
    private Integer price;

    public BookCreateDTO(String title, Integer price) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("책 제목을 입력해주세요.");
        }

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("책 가격을 0보다 큰 값으로 입력해주세요.");
        }

        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

}