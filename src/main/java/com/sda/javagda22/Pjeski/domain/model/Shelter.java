package com.sda.javagda22.Pjeski.domain.model;

import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String telephone;
    private String accountNumber;

    // Szuca - dodana relacja do animala
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shelter")
    private List<Animal> animals;


}
