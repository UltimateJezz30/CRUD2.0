package com.finalclase.CRUD.controller;

import com.example.vehiclecrud.model.Precio;
import com.example.vehiclecrud.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/precios")
public class PrecioController {

    @Autowired
    private PrecioService service;

    @GetMapping
    public List<Precio> getAllPrecios() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> getPrecioById(@PathVariable Long id) {
        Optional<Precio> precio = service.findById(id);
        return precio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Precio createPrecio(@RequestBody Precio precio) {
        return service.save(precio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precio> updatePrecio(@PathVariable Long id, @RequestBody Precio precioDetails) {
        Optional<Precio> precio = service.findById(id);
        if (precio.isPresent()) {
            Precio updatedPrecio = precio.get();
            updatedPrecio.setValor(precioDetails.getValor());
            updatedPrecio.setTipoDeAuto(precioDetails.getTipoDeAuto());
            service.save(updatedPrecio);
            return ResponseEntity.ok(updatedPrecio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrecio(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

