package com.store.onedaySeed.service;

import com.store.onedaySeed.dto.CartDto;
import com.store.onedaySeed.entity.Cart;
import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.repository.CartItemRepository;
import com.store.onedaySeed.repository.CartRepository;
import com.store.onedaySeed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    // 장바구니 조회
    public List<CartDto> getCartList(String userId) {
        List<CartDto> cartList = new ArrayList<>();
        User user = userRepository.findByUserId(userId);
        Cart cart = cartRepository.findByUser_userId(user.getUserId());

        if(cart == null) {
            return cartList;
        }

        cartList = cartItemRepository.findCartList(cart.getCartId());
        return cartList;
    }
}
