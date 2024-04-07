package com.sst.ProductServiceSST.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sst.ProductServiceSST.dtos.FakeStoreProductDto;
import com.sst.ProductServiceSST.models.Product;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        
        //Call the fakeStore API to get the product with give id.
        RestTemplate resTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = resTemplate.getForObject("https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);


        Product product  = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }
    
}
