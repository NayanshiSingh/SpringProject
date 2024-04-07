package com.sst.ProductServiceSST.controllers;



import org.springframework.web.bind.annotation.RestController;

import com.sst.ProductServiceSST.models.Product;
import com.sst.ProductServiceSST.services.FakeStoreProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductController {
   private FakeStoreProductService fakeStoreProductService;
   

   ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
   }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return fakeStoreProductService.getProductById(id);
    }
}

