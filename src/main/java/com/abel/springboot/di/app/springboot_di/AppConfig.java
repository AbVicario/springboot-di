package com.abel.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.abel.springboot.di.app.springboot_di.repositories.ProductReositoryJson;
import com.abel.springboot.di.app.springboot_di.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/Product.json")
    private Resource resource;

    @Bean("productJson") // Si quieres que el nombre sea distinto al del metodo ->
                         // "productRepositoryJson"
    @Primary
    ProductRepository productRepositoryJson() {
        return new ProductReositoryJson(resource);
    }

}
