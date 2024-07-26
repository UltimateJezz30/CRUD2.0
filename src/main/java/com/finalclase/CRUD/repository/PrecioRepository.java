package com.finalclase.CRUD.repository;

package com.example.vehiclecrud.repository;

import com.example.vehiclecrud.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {
}
