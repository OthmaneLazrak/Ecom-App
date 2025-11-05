package org.sid.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomer")
     Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getAllCustomers")
    PagedModel<Customer> allCustomers();


    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .nom("Default Customer")
                .email("Default@gmail.com")
                .build();
    }

    default PagedModel<Customer> getAllCustomers(Exception e){
        return PagedModel.empty();
    }
}
