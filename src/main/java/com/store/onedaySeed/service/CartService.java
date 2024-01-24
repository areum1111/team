package com.store.onedaySeed.service;

import com.store.onedaySeed.dto.CartDto;
import com.store.onedaySeed.entity.Cart;
import com.store.onedaySeed.entity.CartItem;
import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.repository.CartItemRepository;
import com.store.onedaySeed.repository.CartRepository;
import com.store.onedaySeed.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    
    // 장바구니 수정
    @Transactional
    public void updateCart(CartDto cartDto) throws EntityNotFoundException {
        Optional<CartItem> optionalCart = cartItemRepository.findById(cartDto.getCartItemId());

        if (optionalCart.isPresent()) {
            CartItem cartItem = optionalCart.get();
            cartItem.setCount(cartDto.getCount());

            cartItemRepository.save(cartItem);
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

    // 장바구니 삭제
    public void deleteCartItem(Long cartItemId) {
        try {
            CartItem cartItem = cartItemRepository.findById(cartItemId)
                    .orElseThrow(EntityNotFoundException::new);
            cartItemRepository.delete(cartItem);
        } catch (EntityNotFoundException e) {
            // 엔티티가 존재하지 않는 경우에 대한 예외 처리
            throw new RuntimeException("Entity not found for deletion.", e);
        }
    }
    
    // 주문하기
}
