package com.finalclase.CRUD.services;

import com.example.vehiclecrud.model.MarcaDeVehiculo;
import com.example.vehiclecrud.repository.MarcaDeVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaDeVehiculoService {

    @Autowired
    private MarcaDeVehiculoRepository repository;

    public List<MarcaDeVehiculo> findAll() {
        return repository.findAll();
    }

    public Optional<MarcaDeVehiculo> findById(Long id) {
        return repository.findById(id);
    }

    public MarcaDeVehiculo save(MarcaDeVehiculo marca) {
        return repository.save(marca);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

