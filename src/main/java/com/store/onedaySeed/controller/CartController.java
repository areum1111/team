package com.store.onedaySeed.controller;

import com.store.onedaySeed.dto.CartDto;
import com.store.onedaySeed.dto.UserDto;
import com.store.onedaySeed.entity.Cart;
import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.service.CartService;
import com.store.onedaySeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated // @Valid 사용 위함
public class CartController {

    private final CartService cartService;
    
    // 장바구니 추가
    
    // 장바구니 조회 (로그인 정보가 없어서 일단 Principal 제외)
    @GetMapping("/api/cart")
    public List<CartDto> cartList() {
        List<CartDto> cartDtoList = cartService.getCartList("hong");
        return cartDtoList;
    }
    
    // 장바구니 수정(count 업데이트)

    
    // 장바구니 삭제
    
    // 주문하기
}
