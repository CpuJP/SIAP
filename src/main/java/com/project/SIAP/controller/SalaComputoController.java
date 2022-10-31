package com.project.SIAP.controller;

import com.project.SIAP.entities.SalaComputo;
import com.project.SIAP.repository.SalaComputoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@PreAuthorize("hasAnyRole('ADMIN', 'SALC')")
@RequestMapping("/api/crud/salacomputo")
public class SalaComputoController {

    private final Logger log = LoggerFactory.getLogger(SalaComputoController.class);

    private SalaComputoRepository salaComputoRepository;

    public SalaComputoController(SalaComputoRepository salaComputoRepository) {
        this.salaComputoRepository = salaComputoRepository;
    }

    @GetMapping("/all")
    public Iterable<SalaComputo> findAll() {
        return salaComputoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<SalaComputo> findById(@PathVariable Integer id) {
        Optional<SalaComputo> salaCompOpt = salaComputoRepository.findById(id);
        return salaCompOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<SalaComputo> existe(@PathVariable Integer id) {
        if (!salaComputoRepository.existsById(id)) {
            log.warn("NO existe ese registro");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = salaComputoRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<SalaComputo> create(@RequestBody SalaComputo salaComputo, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (salaComputo.getId() != null) {
            log.warn("Intentando crear un registro con id");
            return ResponseEntity.badRequest().build();
        }
        SalaComputo result = salaComputoRepository.save(salaComputo);
        return ResponseEntity.ok(result);
    }
}
