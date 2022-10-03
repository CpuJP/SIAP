package com.project.SIAP.controller;

import com.project.SIAP.entities.Biblioteca;
import com.project.SIAP.repository.BibliotecaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crud/biblioteca")
public class BibliotecaController {

    private final Logger log = LoggerFactory.getLogger(BibliotecaController.class);

    private BibliotecaRepository bibliotecaRepository;

    public BibliotecaController(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @GetMapping("/all")
    public Iterable<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Biblioteca> findById(@PathVariable Integer id) {
        Optional<Biblioteca> bibliotecaOpt = bibliotecaRepository.findById(id);
        return bibliotecaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Biblioteca> existe(@PathVariable Integer id) {
        if (!bibliotecaRepository.existsById(id)) {
            log.warn("NO existe ese registro");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = bibliotecaRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Biblioteca> create(@RequestBody Biblioteca biblioteca, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (biblioteca.getId() != null) {
            log.warn("Intentando crear un regidtro con id");
            return ResponseEntity.badRequest().build();
        }
        Biblioteca result = bibliotecaRepository.save(biblioteca);
        return ResponseEntity.ok(result);
    }
}
