package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.billingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor   @Builder @Getter @Setter
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerID;

    @OneToMany(mappedBy="bill")
    private List<ProductItem> productItems=new ArrayList<>();
    @Transient
    private Customer customer;
}
