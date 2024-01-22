package com.store.onedaySeed.entity;

import com.store.onedaySeed.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

//주문서
@Entity
@Table(name="orders")
@Getter
@Setter
@ToString
public class Orders extends BaseEntity {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "payment_id")
//    private Payment payment;

    @Column(nullable = false , name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status") //주문 상태
    private OrderStatus orderStatus; //ORDER or CANCEL

}
