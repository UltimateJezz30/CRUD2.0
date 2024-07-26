package com.finalclase.CRUD.repository;

import com.example.vehiclecrud.model.TipoDeAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeAutoRepository extends JpaRepository<TipoDeAuto, Long> {
}
