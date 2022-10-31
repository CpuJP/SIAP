package com.project.SIAP.controller;

import com.project.SIAP.entities.Campus;
import com.project.SIAP.repository.CampusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@PreAuthorize("hasAnyRole('ADMIN', 'CAMP')")
@RequestMapping("/api/crud/campus")
public class CampusController {

    private final Logger log = LoggerFactory.getLogger(CampusController.class);

    private CampusRepository campusRepository;

    public CampusController(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    @GetMapping("/all")
    public Iterable<Campus> findAll() {
        return campusRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Campus> findById(@PathVariable Integer id) {
        Optional<Campus> campusOpt = campusRepository.findById(id);
        return campusOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/existe/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Campus> existe(@PathVariable Integer id) {
        if (!campusRepository.existsById(id)) {
            log.warn("NO existe ese registro");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contador")
    public Long contador() {
        Long result = campusRepository.count();
        return ResponseEntity.ok(result).getBody();
    }

    @PostMapping("/crear")
    public ResponseEntity<Campus> create(@RequestBody Campus campus, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (campus.getId() != null) {
            log.warn("Intentando crear in registro con ID");
            return ResponseEntity.badRequest().build();
        }
        Campus result = campusRepository.save(campus);
        return ResponseEntity.ok(result);
    }
}
