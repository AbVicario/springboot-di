package com.abel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.abel.springboot.di.app.springboot_di.models.Product;
import com.abel.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private Environment envaironment; // Forma de importar propiedades del archivo config.properties a traves de la
                                      // clase Envairoment
    private ProductRepository repository;

    @Value("${config.price.tax}") // Forma de importar propiedades del archivo config.properties
    private Double tax;

    public ProductServiceImpl(ProductRepository repository, Environment envaironment) {
        this.repository = repository;
        this.envaironment = envaironment;
    }

    @Override
    public List<Product> findAll() {
        System.out.println(tax);
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * envaironment.getProperty("config.price.tax", Double.class);
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            // p.setPrice(priceTax.longValue());
            return newProduct;
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
