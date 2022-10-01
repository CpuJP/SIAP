package com.project.SIAP.repository;

import com.project.SIAP.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>, JpaSpecificationExecutor<Prestamo> {
}