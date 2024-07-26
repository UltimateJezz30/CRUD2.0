package com.finalclase.CRUD.controller;

import com.example.vehiclecrud.model.MarcaDeVehiculo;
import com.example.vehiclecrud.service.MarcaDeVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas")
public class MarcaDeVehiculoController {

    @Autowired
    private MarcaDeVehiculoService service;

    @GetMapping
    public List<MarcaDeVehiculo> getAllMarcas() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDeVehiculo> getMarcaById(@PathVariable Long id) {
        Optional<MarcaDeVehiculo> marca = service.findById(id);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MarcaDeVehiculo createMarca(@RequestBody MarcaDeVehiculo marca) {
        return service.save(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDeVehiculo> updateMarca(@PathVariable Long id, @RequestBody MarcaDeVehiculo marcaDetails) {
        Optional<MarcaDeVehiculo> marca = service.findById(id);
        if (marca.isPresent()) {
            MarcaDeVehiculo updatedMarca = marca.get();
            updatedMarca.setNombre(marcaDetails.getNombre());
            service.save(updatedMarca);
            return ResponseEntity.ok(updatedMarca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
