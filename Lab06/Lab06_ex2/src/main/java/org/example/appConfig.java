package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
public class appConfig {
    @Bean
    public Product product1() {
        return new Product(1,"Bean 1", 10.0,"Description for Bean 1");
    }

    @Bean
    public Product product2() {
        return new Product(2,"Bean 2", 20.0,"Description for Bean 2");
    }

    @Bean
    @Scope("singleton")
    public Product product3() {
        return new Product(3, "Bean 3", 30.0,"Description for Bean 3");
    }
}
