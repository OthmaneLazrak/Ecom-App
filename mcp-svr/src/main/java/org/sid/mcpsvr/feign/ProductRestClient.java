package org.sid.mcpsvr.feign;

import org.sid.mcpsvr.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="inventory-service")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable String id);

    @GetMapping("/products/all")
    List<Product> getAllProducts();



}
