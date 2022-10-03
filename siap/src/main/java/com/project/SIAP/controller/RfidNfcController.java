package com.project.SIAP.controller;

import com.project.SIAP.entities.PersonalUniversidad;
import com.project.SIAP.entities.RfidNfc;
import com.project.SIAP.repository.RfidNfcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crud/rfidnfc")
public class RfidNfcController {

    private final Logger log = LoggerFactory.getLogger(RfidNfcController.class);

    private RfidNfcRepository rfidNfcRepository;

    public RfidNfcController(RfidNfcRepository rfidNfcRepository) {
        this.rfidNfcRepository = rfidNfcRepository;
    }

    @GetMapping("/all")
    public Iterable<RfidNfc> findAll() {
        return rfidNfcRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<RfidNfc> findOneById(@PathVariable String id) {
        Optional<RfidNfc> rfidOpt = rfidNfcRepository.findById(id);
        return rfidOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<RfidNfc> existe(@PathVariable String id) {
        if (!rfidNfcRepository.existsById(id)) {
            log.warn("NO existe ningún carnet con ese ID");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = rfidNfcRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<RfidNfc> create(@RequestBody RfidNfc rfidNfc, @RequestHeader HttpHeaders header) {
        System.out.println(header.get("User-Agent"));
        if (rfidNfc.getId() == null || rfidNfc.getId().length() == 0) {
            log.warn("Debe llenar el campo de ID");
            System.out.println("Debe llenar el campo de ID");
            return ResponseEntity.badRequest().build();
        }
        String varificarId = rfidNfc.getId();
        if (rfidNfcRepository.existsById(varificarId)) {
            log.warn("Este Carnet ya está en uso");
            return ResponseEntity.badRequest().build();
        }
        RfidNfc result = rfidNfcRepository.save(rfidNfc);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<RfidNfc> update(@RequestBody RfidNfc rfidNfc) {
        if (rfidNfc.getId() ==  null) {
            log.warn("Intentado actualizar un libro que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!rfidNfcRepository.existsById(rfidNfc.getId())) {
            log.warn("Intentado actualizar un libro que no existe");
            return ResponseEntity.notFound().build();
        }
        RfidNfc resultado = rfidNfcRepository.save(rfidNfc);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<RfidNfc> delete(@PathVariable String id) {
        if (!rfidNfcRepository.existsById(id)) {
            log.warn("Intentado eliminar un libro que no existe");
            return ResponseEntity.notFound().build();
        }
        rfidNfcRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
