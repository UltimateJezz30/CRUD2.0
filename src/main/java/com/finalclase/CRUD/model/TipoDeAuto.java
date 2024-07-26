package com.finalclase.CRUD.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TipoDeAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaDeVehiculo marcaDeVehiculo;

    @OneToMany(mappedBy = "tipoDeAuto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Precio> precios;

    // Getters and Setters
}
