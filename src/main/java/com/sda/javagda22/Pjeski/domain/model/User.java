package com.sda.javagda22.Pjeski.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String postalCode;
    private String emailAdress;
//    todo osiągnięcia za największe datki itp
//    todo logowanie
//    - tylko login widoczny dla innych w HallOfFame z powodu RODO itp
//    HallOfFame to nowa klasa?
    /* póki co hall of fame możemy sobie zostawić
    na sam koniec, bo dodanie tego to tam nawet nie wiem czy ma sens, dlatego póki co olejmy temat
    a co do, osiągnięć, to ja to widzę tak, że przy zalogowanym nicku po prostu danemu userowi będzię się wyświetlało
    przy jego nicku coś jak na allegro "zaufany sprzedawca"
     */



}
