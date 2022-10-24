package com.project.SIAP.controller;

import com.project.SIAP.entities.Administrativo;
import com.project.SIAP.repository.AdministrativoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/crud/administrativo")
public class AdministrativoController {

    private final Logger log = LoggerFactory.getLogger(AdministrativoController.class);

    private AdministrativoRepository administrativoRepository;

    public AdministrativoController(AdministrativoRepository administrativoRepository) {
        this.administrativoRepository = administrativoRepository;
    }

    @GetMapping("/all")
    public Iterable<Administrativo> findAll() {
        return administrativoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Administrativo> findById(@PathVariable Integer id) {
        Optional<Administrativo> adminOpt = administrativoRepository.findById(id);
        return adminOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Administrativo> existe(@PathVariable Integer id) {
        if (!administrativoRepository.existsById(id)) {
            log.warn("NO existe ningún administrativo con ese ID");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = administrativoRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Administrativo> create(@RequestBody Administrativo administrativo, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (administrativo.getId() == null) {
            log.warn("Debe llenar el campos de ID");
            return ResponseEntity.badRequest().build();
        }
        Integer varificarId = administrativo.getId();
        if (administrativoRepository.existsById(varificarId)) {
            log.warn("Este usuario ya existe");
            return ResponseEntity.badRequest().build();
        }
        Administrativo result = administrativoRepository.save(administrativo);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Administrativo> update(@RequestBody Administrativo administrativo) {
        if (administrativo.getId() == null) {
            log.warn("Intentando actualizar un administrativo que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!administrativoRepository.existsById(administrativo.getId())) {
            log.warn("Intentando actualizar un administrativo que no existe");
            return ResponseEntity.badRequest().build();
        }
        Administrativo result = administrativoRepository.save(administrativo);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/eliminar/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Administrativo> delete(@PathVariable Integer id) {
        if (!administrativoRepository.existsById(id)) {
            log.warn("Intentando eliminar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        administrativoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
