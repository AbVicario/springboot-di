package com.abel.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.abel.springboot.di.app.springboot_di.models.Product;

@Repository
@RequestScope
public class ProductRepositoryImpl implements ProductRepository {

    @SuppressWarnings("FieldMayBeFinal")
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "CPU IntelCore i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 18L),
                new Product(4L, "Motherboard Gigabyte", 490L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
