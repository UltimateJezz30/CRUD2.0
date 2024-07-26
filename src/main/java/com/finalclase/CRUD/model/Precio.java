package com.finalclase.CRUD.model;

import javax.persistence.*;

@Entity
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoDeAuto tipoDeAuto;

    // Getters and Setters
}
