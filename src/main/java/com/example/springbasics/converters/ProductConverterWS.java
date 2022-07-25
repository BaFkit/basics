package com.example.springbasics.converters;

import com.example.springbasics.entities.Product;
import com.example.springbasics.soap.products.ProductWS;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterWS {

    public Product dtoToEntity(ProductWS productWS) {
        return new Product(productWS.getId(), productWS.getTitle(), productWS.getCost());
    }

    public ProductWS entityToDto(Product product) {
        ProductWS productWS = new ProductWS();
        productWS.setId(product.getId());
        productWS.setTitle(product.getTitle());
        productWS.setCost(product.getCost());
        return productWS;
    }
}
