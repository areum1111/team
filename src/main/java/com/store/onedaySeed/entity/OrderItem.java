package com.store.onedaySeed.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

//주문상품
    @Entity
    @Table(name="order_item")
    @Getter
    @Setter
    @ToString
    public class OrderItem extends BaseEntity{

        @Id
        @Column(name = "order_item_id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long orderItemId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="order_id")
        private Orders order;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="lesson_id")
        private Lesson lesson;

        private int count;

        private Long orderPrice;
    }


