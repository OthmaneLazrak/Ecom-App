package org.sid.mcpsvr.feign;

import org.sid.mcpsvr.config.FeignConfig;
import org.sid.mcpsvr.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
    @GetMapping("/customers/all")
    List<Customer> getAllCustomers();
}
