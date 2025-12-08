package org.sid.mcpsvr.tools;


import org.sid.mcpsvr.feign.CustomerRestClient;
import org.sid.mcpsvr.feign.ProductRestClient;
import org.sid.mcpsvr.model.Customer;
import org.sid.mcpsvr.model.Product;
import org.springaicommunity.mcp.annotation.McpArg;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class McpTools {

    @Autowired
    private CustomerRestClient customerRestClient;

    @Autowired
    private ProductRestClient productRestClient;

    @McpTool(name = "getCustomer", description = "Get information about a given customer")
    public Customer getCustomer(@McpArg(description = "The Customer id") Long id){
        return customerRestClient.getCustomerById(id);
    }


    @McpTool(name = "AllCustomers", description = "Get All customers")
    public List<Customer> AllCustomers() {
        return customerRestClient.getAllCustomers();

    }

    @McpTool(name = "getProduct", description = "Get information about a given product")
    public Product getProduct(@McpArg(description = "The Product id") String id){
        return productRestClient.findProductById(id);
    }

    @McpTool(name = "getAllProducts", description = "Get All products")
    public List<Product> getAllProducts(){
        return productRestClient.getAllProducts();
    }


}


