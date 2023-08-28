package com.example.Retail.Store.repository;

import com.example.Retail.Store.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Integer> {
}
