package com.finalclase.CRUD.services;

import com.example.vehiclecrud.model.TipoDeAuto;
import com.example.vehiclecrud.repository.TipoDeAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeAutoService {

    @Autowired
    private TipoDeAutoRepository repository;

    public List<TipoDeAuto> findAll() {
        return repository.findAll();
    }

    public Optional<TipoDeAuto> findById(Long id) {
        return repository.findById(id);
    }

    public TipoDeAuto save(TipoDeAuto tipo) {
        return repository.save(tipo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}