package com.sda.javagda22.Pjeski.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Schronisko {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String address;
    private String city;
    private String telephone;

}
