package com.example.Retail.Store.controller;

import com.example.Retail.Store.exception.ProductNotFoundException;
import com.example.Retail.Store.model.Products;
import com.example.Retail.Store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    Products newUser(@RequestBody Products newProduct) {
        return productRepository.save(newProduct);
    }
    @GetMapping("/products")
    List<Products> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Products getUserById(@PathVariable int id) {
        return (Products) productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    @PutMapping("/product/{id}")
    Products updateUser(@RequestBody Products products, @PathVariable int id) {
        return productRepository.findById(id)
                .map(product-> {
                    product.setName(products.getName());
                    product.setDescription(products.getDescription());
                    product.setProduct_code(products.getProduct_code());
                    product.setPrice(products.getPrice());
                    return productRepository.save(products);

                }).orElseThrow(() -> new ProductNotFoundException(id));
    }


    @DeleteMapping("/product/{id}")
    String deleteUser(@PathVariable int id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return  "Product with id "+id+" has been deleted success.";
    }


}

