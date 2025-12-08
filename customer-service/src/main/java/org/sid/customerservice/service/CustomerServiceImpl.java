package org.sid.customerservice.service;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer){
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
        existingCustomer.setNom(customer.getNom());
        existingCustomer.setEmail(customer.getEmail());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
