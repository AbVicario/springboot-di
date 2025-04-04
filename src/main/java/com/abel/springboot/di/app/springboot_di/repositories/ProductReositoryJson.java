package com.abel.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.abel.springboot.di.app.springboot_di.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductReositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductReositoryJson() {
        Resource resource = new ClassPathResource("json/Product.json");
        readValueJson(resource);
    }

    public ProductReositoryJson(Resource resource) {
        readValueJson(resource);
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
