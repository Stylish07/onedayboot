package com.yse.dev.book.dto;

public class BookCreateDTO {

    private String title;

    private Integer price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("책 제목을 입력해주세요.");
        }

        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("책 가격을 올바르게 입력해주세요.");
        }

        this.price = price;
    }

}
