package com.project.SIAP.controller;

import com.project.SIAP.entities.Egresado;
import com.project.SIAP.repository.EgresadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/crud/egresado")
public class EgresadoController {

    private final Logger log = LoggerFactory.getLogger(EgresadoController.class);

    private EgresadoRepository egresadoRepository;

    public EgresadoController(EgresadoRepository egresadoRepository) {
        this.egresadoRepository = egresadoRepository;
    }

    @GetMapping("/all")
    public Iterable<Egresado> findAll() {
        return egresadoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Egresado> findById(@PathVariable Integer id) {
        Optional<Egresado> egresadoOpt = egresadoRepository.findById(id);
        return egresadoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Egresado> existe(@PathVariable Integer id) {
        if (!egresadoRepository.existsById(id)) {
            log.warn("NO existe ningún egresado con ese ID");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = egresadoRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Egresado> create(@RequestBody Egresado egresado, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (egresado.getId() == null) {
            log.warn("Debe llenar el campo de ID");
            return ResponseEntity.badRequest().build();
        }
        Integer verificarId = egresado.getId();
        if (egresadoRepository.existsById(verificarId)) {
            log.warn("Este usuario ya existe");
            return ResponseEntity.badRequest().build();
        }
        Egresado result = egresadoRepository.save(egresado);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Egresado> update(@RequestBody Egresado egresado) {
        if (egresado.getId() == null) {
            log.warn("Intentando actualizar un egresado que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!egresadoRepository.existsById(egresado.getId())) {
            log.warn("intentado actualizar un egresado que no existe");
            return ResponseEntity.badRequest().build();
        }
        Egresado result = egresadoRepository.save(egresado);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/eliminar/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Egresado> delete(@PathVariable Integer id) {
        if (!egresadoRepository.existsById(id)) {
            log.warn("Intentado eliminar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        egresadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
