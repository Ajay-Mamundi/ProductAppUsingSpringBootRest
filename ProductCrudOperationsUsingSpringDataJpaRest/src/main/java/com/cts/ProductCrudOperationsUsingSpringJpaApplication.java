package com.cts;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.model.Product;
import com.cts.service.ProductService;

@SpringBootApplication
public class ProductCrudOperationsUsingSpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(ProductCrudOperationsUsingSpringJpaApplication.class, args);

	}

}
