package com.store.onedaySeed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private Long cartItemId;

    private String lessonName;

    private String lessonSchedule;

    private int count;

    private Long price;

    public CartDto(Long cartItemId, String lessonName, String lessonSchedule, int count, Long price) {
        this.cartItemId = cartItemId;
        this.lessonName = lessonName;
        this.lessonSchedule = lessonSchedule;
        this.count = count;
        this.price = price;
    }
}
