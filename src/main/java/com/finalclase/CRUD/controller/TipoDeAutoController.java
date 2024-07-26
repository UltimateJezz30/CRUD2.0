package com.finalclase.CRUD.controller;

import com.example.vehiclecrud.model.TipoDeAuto;
import com.example.vehiclecrud.service.TipoDeAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos")
public class TipoDeAutoController {

    @Autowired
    private TipoDeAutoService service;

    @GetMapping
    public List<TipoDeAuto> getAllTipos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeAuto> getTipoById(@PathVariable Long id) {
        Optional<TipoDeAuto> tipo = service.findById(id);
        return tipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoDeAuto createTipo(@RequestBody TipoDeAuto tipo) {
        return service.save(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeAuto> updateTipo(@PathVariable Long id, @RequestBody TipoDeAuto tipoDetails) {
        Optional<TipoDeAuto> tipo = service.findById(id);
        if (tipo.isPresent()) {
            TipoDeAuto updatedTipo = tipo.get();
            updatedTipo.setNombre(tipoDetails.getNombre());
            updatedTipo.setMarcaDeVehiculo(tipoDetails.getMarcaDeVehiculo());
            service.save(updatedTipo);
            return ResponseEntity.ok(updatedTipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
