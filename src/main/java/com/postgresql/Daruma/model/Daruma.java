package com.postgresql.Daruma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "daruma")
public class Daruma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String objetivo;
    private Integer color;
    private Boolean rightEye;
    private Boolean leftEye;
    private Integer skin;

}