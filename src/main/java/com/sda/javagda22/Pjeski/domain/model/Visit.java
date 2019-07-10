package com.sda.javagda22.Pjeski.domain.model;

import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    private String date;

    @OneToOne
    private Animal animal;
    @OneToOne
    private User user;

}
