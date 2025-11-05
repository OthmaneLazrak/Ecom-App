package org.sid.billingservice.model;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String nom;
    private String email;
}
