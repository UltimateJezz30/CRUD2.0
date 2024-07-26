package com.finalclase.CRUD.services;

import com.example.vehiclecrud.model.Precio;
import com.example.vehiclecrud.repository.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecioService {

    @Autowired
    private PrecioRepository repository;

    public List<Precio> findAll() {
        return repository.findAll();
    }

    public Optional<Precio> findById(Long id) {
        return repository.findById(id);
    }

    public Precio save(Precio precio) {
        return repository.save(precio);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

