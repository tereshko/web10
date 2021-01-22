package me.tereshko.web9.services;

import lombok.RequiredArgsConstructor;
import me.tereshko.web9.dto.ProductDto;
import me.tereshko.web9.exceptions_handling.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final List<ProductDto> cartList = new ArrayList<>();
    private final ProductService productService;

    public void addProductToCart(Long id) {
        ProductDto productDto = productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't found"));
        cartList.add(productDto);
    }

    public List<ProductDto> getCartList() {
        return cartList;
    }
}
