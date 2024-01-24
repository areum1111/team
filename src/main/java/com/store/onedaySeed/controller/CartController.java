package com.store.onedaySeed.controller;

import com.store.onedaySeed.dto.CartDto;
import com.store.onedaySeed.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    
    // 장바구니 추가 // 남아있는 수량 체크(그 이상으로 담으면 불가 + alert)
    
    // 장바구니 조회 (로그인 정보가 없어서 일단 Principal 제외)
    @GetMapping("/api/cart")
    public List<CartDto> cartList() {
        List<CartDto> cartDtoList = cartService.getCartList("hong");
        return cartDtoList;
    }
    
    // 장바구니 수정(count 업데이트)
    @PostMapping("/api/cart")
    public ResponseEntity<?> cartUpdate(@RequestBody CartDto cartDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){ // 오류가 발생하였을 경우, 클라이언트에게 오류 메시지 전송
            Map<String, Object> errors = new HashMap<>();
            // 에러 메시지와 함께 alert 메시지 추가
            errors.put("alertMessage", "변경사항 저장에 실패했습니다.");
            errors.put("errors", bindingResult.getAllErrors());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        try {
            cartService.updateCart(cartDto);
            // 수정 성공시, 클라이언트에게 성공 메시지 전송
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("successMessage", "장바구니가 저장되었습니다.");
            successResponse.put("alertMessage", "장바구니가 저장되었습니다.");

            return ResponseEntity.ok(successResponse);

        } catch (Exception e){
            Map<String, String> errors = new HashMap<>();
            // 에러 메시지와 함께 alert 메시지 추가
            errors.put("alertMessage", "변경사항 저장에 실패했습니다.");
            errors.put("errorMessage", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
    }
    
    // 장바구니 삭제 (로그인 정보가 없어서 일단 Principal 제외)
    @DeleteMapping("/api/cart/{cartItemId}")
    public @ResponseBody ResponseEntity deleteCartItem(@PathVariable("cartItemId") Long cartItemId) {
        cartService.deleteCartItem(cartItemId);
        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
    }
    
    // 주문하기(결제)
}
