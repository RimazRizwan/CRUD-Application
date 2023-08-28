package com.example.Retail.Store.exception;


public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(int id){
        super("Could not found the user with id "+ id);
    }
}
