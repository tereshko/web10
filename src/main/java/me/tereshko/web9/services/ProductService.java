package me.tereshko.web9.services;

import lombok.RequiredArgsConstructor;
import me.tereshko.web9.dto.ProductDto;
import me.tereshko.web9.models.Product;
import me.tereshko.web9.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Page<ProductDto> findAll(Specification<Product> spec, Pageable pageable) {
        return productRepository.findAll(spec,pageable).map(ProductDto::new);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }
}
