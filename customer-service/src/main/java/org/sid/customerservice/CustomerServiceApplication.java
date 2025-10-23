package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
							.nom("Othmane")
							.email("othmane@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.nom("Omar")
					.email("omar@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.nom("Achraf")
					.email("achraf@gmail.com")
					.build());
			customerRepository.findAll().forEach(customer -> {
				System.out.println("==============================");
				System.out.println(customer.getId());
				System.out.println(customer.getNom());
				System.out.println(customer.getEmail());
				System.out.println("==============================");

			});
		};
	}

}
