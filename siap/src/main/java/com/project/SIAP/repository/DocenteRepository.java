package com.project.SIAP.repository;

import com.project.SIAP.entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DocenteRepository extends JpaRepository<Docente, Integer>, JpaSpecificationExecutor<Docente> {
}