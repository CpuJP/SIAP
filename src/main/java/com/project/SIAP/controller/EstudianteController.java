package com.project.SIAP.controller;

import com.project.SIAP.entities.Estudiante;
import com.project.SIAP.repository.EstudianteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/crud/estudiante")
public class EstudianteController {

    private final Logger log = LoggerFactory.getLogger(EstudianteController.class);

    private EstudianteRepository estudianteRepository;

    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @GetMapping("/all")
    public Iterable<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
    method = RequestMethod.GET)
    public ResponseEntity<Estudiante> findById(@PathVariable Integer id) {
        Optional<Estudiante> estudianteOpt = estudianteRepository.findById(id);
        return estudianteOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Estudiante> existe(@PathVariable Integer id) {
        if (!estudianteRepository.existsById(id)) {
            log.warn("NO existe ningún estudiante con ese ID");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = estudianteRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (estudiante.getId() == null) {
            log.warn("Debe llenar el campo de ID");
            return ResponseEntity.badRequest().build();
        }
        Integer verificarId = estudiante.getId();
        if (estudianteRepository.existsById(verificarId)) {
            log.warn("Este usuario ya existe");;
            return ResponseEntity.badRequest().build();
        }
        Estudiante result = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante) {
        if (estudiante.getId() == null) {
            log.warn("Intentando actualizar un estudiante que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!estudianteRepository.existsById(estudiante.getId())) {
            log.warn("Intentando actualizar un estudiante que no existe");
            return ResponseEntity.badRequest().build();
        }
        Estudiante result = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/eliminar/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Estudiante> delete(@PathVariable Integer id) {
        if (!estudianteRepository.existsById(id)) {
            log.warn("Intentando eliminar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        estudianteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
