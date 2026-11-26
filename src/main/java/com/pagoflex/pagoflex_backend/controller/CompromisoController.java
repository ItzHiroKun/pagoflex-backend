package com.pagoflex.pagoflex_backend.controller;

import com.pagoflex.pagoflex_backend.model.Compromiso;
import com.pagoflex.pagoflex_backend.repository.CompromisoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compromisos")
@CrossOrigin(origins = "*")
public class CompromisoController {

    private final CompromisoRepository repository;

    public CompromisoController(CompromisoRepository repository) {
        this.repository = repository;
    }

    // 1. GET: Obtener todos los compromisos (Agente / Ejecutivo)
    @GetMapping
    public List<Compromiso> listarTodos() {
        return repository.findAll();
    }

    // 2. GET: Obtener compromisos por RUT de usuario (Usuario Final)
    @GetMapping("/usuario/{rut}")
    public List<Compromiso> listarPorRut(@PathVariable String rut) {
        return repository.findByUsuarioRut(rut);
    }

    // 3. POST: Crear nuevo compromiso (Ejecutivo)
    @PostMapping
    public Compromiso crear(@RequestBody Compromiso compromiso) {
        if (compromiso.getEstado() == null || compromiso.getEstado().isBlank()) {
            compromiso.setEstado("PENDIENTE");
        }
        return repository.save(compromiso);
    }

    // 4. PUT: Marcar compromiso como PAGADO (Usuario Final)
    @PutMapping("/{id}/pagar")
    public ResponseEntity<Compromiso> pagar(@PathVariable Long id) {
        return repository.findById(id)
                .map(c -> {
                    c.setEstado("PAGADO");
                    return ResponseEntity.ok(repository.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. PUT: Actualizar datos generales de un compromiso
    @PutMapping("/{id}")
    public ResponseEntity<Compromiso> actualizar(@PathVariable Long id, @RequestBody Compromiso datos) {
        return repository.findById(id)
                .map(c -> {
                    c.setEmpresaNombre(datos.getEmpresaNombre());
                    c.setDescripcion(datos.getDescripcion());
                    c.setMonto(datos.getMonto());
                    c.setFechaVencimiento(datos.getFechaVencimiento());
                    c.setEstado(datos.getEstado());
                    return ResponseEntity.ok(repository.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 6. DELETE: Anular / Eliminar compromiso (Agente / Ejecutivo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}