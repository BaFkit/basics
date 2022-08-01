package com.example.springbasics.core.endpoints;

import com.example.springbasics.core.services.interfaces.ProductService;
import com.example.springbasics.core.converters.ProductConverterWS;
import com.example.springbasics.core.soap.products.GetAllProductsRequest;
import com.example.springbasics.core.soap.products.GetAllProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/springbasics/products";
    private final ProductService productService;
    private final ProductConverterWS productConverterWS;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productService.getAll().stream().map(productConverterWS::entityToDto).forEach(response.getProducts()::add);
        return response;
    }
}
