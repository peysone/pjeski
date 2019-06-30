package com.sda.javagda22.Pjeski.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Shelter {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String telephone;
    private String accountNumber;

}
