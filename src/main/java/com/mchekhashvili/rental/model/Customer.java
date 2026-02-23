package com.mchekhashvili.rental.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name", nullable = false)
    private String fullName;

    /**
     * @TODO relations would be better for more details...
     */
    @Column(name="identification_document")
    private String identificationDocument;
    @Column(name="contact_information")
    private String contactInformation;
}
