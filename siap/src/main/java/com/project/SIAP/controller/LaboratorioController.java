package com.project.SIAP.controller;

import com.project.SIAP.entities.Laboratorio;
import com.project.SIAP.repository.LaboratorioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crud/laboratorio")
public class LaboratorioController {

    private final Logger log = LoggerFactory.getLogger(LaboratorioController.class);

    private LaboratorioRepository laboratorioRepository;

    public LaboratorioController(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @GetMapping("/all")
    public Iterable<Laboratorio> findAll() {
        return laboratorioRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Laboratorio> findById(@PathVariable Integer id) {
        Optional<Laboratorio> labOpt = laboratorioRepository.findById(id);
        return labOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Laboratorio> existe(@PathVariable Integer id) {
        if (!laboratorioRepository.existsById(id)) {
            log.warn("NO existe ese registro");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = laboratorioRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Laboratorio> create(@RequestBody Laboratorio laboratorio, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (laboratorio.getId() != null) {
            log.warn("Intentando crear un registro con id");
            return ResponseEntity.badRequest().build();
        }
        Laboratorio result = laboratorioRepository.save(laboratorio);
        return ResponseEntity.ok(result);
    }
}
