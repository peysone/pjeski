package com.sda.javagda22.Pjeski.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String role;
}
