package me.tereshko.web9.controllers;

import lombok.RequiredArgsConstructor;
import me.tereshko.web9.dto.ProductDto;
import me.tereshko.web9.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/api/v1/cart/")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> showCart() {
        Map<String, Object> response = new HashMap<>();
        response.put("cart", cartService.getCartList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public void cartItem(@PathVariable Long id) {
        cartService.addProductToCart(id);
    }
}
