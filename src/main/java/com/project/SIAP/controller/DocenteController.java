package com.project.SIAP.controller;

import com.project.SIAP.entities.Docente;
import com.project.SIAP.repository.DocenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/crud/docente")
public class DocenteController {

    private final Logger log = LoggerFactory.getLogger(DocenteController.class);

    private DocenteRepository docenteRepository;

    public DocenteController(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @GetMapping("/all")
    public Iterable<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Docente> findById(@PathVariable Integer id) {
        Optional<Docente> docenteOpt = docenteRepository.findById(id);
        return docenteOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Docente> existe(@PathVariable Integer id) {
        if (!docenteRepository.existsById(id)) {
            log.warn("NO existe ningún docente con ese ID");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = docenteRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Docente> create(@RequestBody Docente docente, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (docente.getId() == null) {
            log.warn("Debe llenar el campo de ID");
            return ResponseEntity.badRequest().build();
        }
        Integer verificarId = docente.getId();
        if (docenteRepository.existsById(verificarId)) {
            log.warn("Este usuario ya existe");
            return ResponseEntity.badRequest().build();
        }
        Docente result = docenteRepository.save(docente);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Docente> update(@RequestBody Docente docente) {
        if (docente.getId() == null) {
            log.warn("Intentado actualizar un docente que no existe");
            return ResponseEntity.badRequest().build();
        }
        if(!docenteRepository.existsById(docente.getId())) {
            log.warn("Intentando actualizar un docente que no existe");
            return ResponseEntity.badRequest().build();
        }
        Docente result = docenteRepository.save(docente);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/eliminar/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Docente> delete(@PathVariable Integer id) {
        if (!docenteRepository.existsById(id)) {
            log.warn("Intentando eliminar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        docenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
