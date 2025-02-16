package com.abel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.abel.springboot.di.app.springboot_di.models.Product;
import com.abel.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    @SuppressWarnings("FieldMayBeFinal")
    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product finById(Long id) {
        return repository.finById(id);
    }

}
