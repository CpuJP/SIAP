package com.project.SIAP.repository;

import com.project.SIAP.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>, JpaSpecificationExecutor<Estudiante> {
}