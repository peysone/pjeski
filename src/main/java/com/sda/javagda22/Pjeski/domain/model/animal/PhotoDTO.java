package com.sda.javagda22.Pjeski.domain.model.animal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="photos")
public class PhotoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;
    private String fileName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animal animal;
}
