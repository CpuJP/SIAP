package com.project.SIAP.controller;

import com.project.SIAP.entities.PersonalUniversidad;
import com.project.SIAP.entities.RfidNfc;
import com.project.SIAP.repository.PersonalUniversidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crud/personaluniversidad")
public class PersonalUniversidadController {

    private final Logger log = LoggerFactory.getLogger(PersonalUniversidadController.class);

    private PersonalUniversidadRepository personalUniversidadRepository;

    public PersonalUniversidadController(PersonalUniversidadRepository personalUniversidadRepository) {
        this.personalUniversidadRepository = personalUniversidadRepository;
    }

    @GetMapping("/all")
    public Iterable<PersonalUniversidad> findAll() {
        return personalUniversidadRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PersonalUniversidad> findById(@PathVariable String id) {
        Optional<PersonalUniversidad> personalOpt = personalUniversidadRepository.findById(id);
        return personalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/buscar/byrfid")
    public ResponseEntity<PersonalUniversidad> findByRfidNfc(@RequestBody RfidNfc rfidNfc) {
        Optional<PersonalUniversidad> personalOpt = personalUniversidadRepository.findByRfidNfcIdCarnet(rfidNfc);
        return personalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<PersonalUniversidad> existe(@PathVariable String id) {
        if (!personalUniversidadRepository.existsById(id)) {
            log.warn(("No existe ninguna persona con ese ID"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = personalUniversidadRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<PersonalUniversidad> create(@RequestBody PersonalUniversidad personalUniversidad, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (personalUniversidad.getId() == null || personalUniversidad.getId().length() == 0) {
            log.warn("Debe llenar el campo de ID");
            System.out.println("Debe llenar el campo de ID");
            return ResponseEntity.badRequest().build();
        }
        String verificarId = personalUniversidad.getId();
        if (personalUniversidadRepository.existsById(verificarId)) {
            log.warn("Este usuario ya existe");
            return ResponseEntity.badRequest().build();
        }
        PersonalUniversidad result = personalUniversidadRepository.save(personalUniversidad);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PersonalUniversidad> update(@RequestBody PersonalUniversidad personalUniversidad) {
        if (personalUniversidad.getId() == null) {
            log.warn(("Intentado actualizar una persona que no existe"));
            return ResponseEntity.badRequest().build();
        }
        if (!personalUniversidadRepository.existsById(personalUniversidad.getId())) {
            log.warn("Intentando actualizar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        PersonalUniversidad resultado = personalUniversidadRepository.save(personalUniversidad);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PersonalUniversidad> delete(@PathVariable String id) {
        if (!personalUniversidadRepository.existsById(id)) {
            log.warn("Intentando eliminar una persona que no existe");
            return ResponseEntity.notFound().build();
        }
        personalUniversidadRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
