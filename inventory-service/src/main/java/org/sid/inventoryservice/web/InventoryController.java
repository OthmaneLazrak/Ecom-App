package org.sid.inventoryservice.web;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return inventoryService.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return inventoryService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return inventoryService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        inventoryService.deleteProduct(id);
    }
}
