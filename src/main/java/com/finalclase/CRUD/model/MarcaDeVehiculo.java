package com.finalclase.CRUD.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MarcaDeVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "marcaDeVehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TipoDeAuto> tiposDeAuto;

    // Getters and Setters
}

