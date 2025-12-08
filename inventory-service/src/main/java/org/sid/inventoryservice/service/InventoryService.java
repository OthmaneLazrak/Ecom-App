package org.sid.inventoryservice.service;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product){
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
}
