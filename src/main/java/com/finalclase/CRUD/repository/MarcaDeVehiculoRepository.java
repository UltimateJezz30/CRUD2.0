package com.finalclase.CRUD.repository;

import com.example.vehiclecrud.model.MarcaDeVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaDeVehiculoRepository extends JpaRepository<MarcaDeVehiculo, Long> {
}