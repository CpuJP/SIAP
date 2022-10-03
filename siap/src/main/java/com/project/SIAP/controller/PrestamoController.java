package com.project.SIAP.controller;

import com.project.SIAP.entities.Campus;
import com.project.SIAP.entities.Prestamo;
import com.project.SIAP.repository.PrestamoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crud/prestamos")
public class PrestamoController {

    private final Logger log = LoggerFactory.getLogger(PrestamoController.class);

    private PrestamoRepository prestamoRepository;

    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping("/all")
    public Iterable<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Prestamo> findById(@PathVariable Integer id) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(id);
        return prestamoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Prestamo> existe(@PathVariable Integer id) {
        if (!prestamoRepository.existsById(id)) {
            log.warn("NO existe ese registro");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = prestamoRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Prestamo> create(@RequestBody Prestamo prestamo, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (prestamo.getId() != null) {
            log.warn("Intentando crear un registro con ID");
            return ResponseEntity.badRequest().build();
        }
        Prestamo result = prestamoRepository.save(prestamo);
        return ResponseEntity.ok(result);
    }
}
