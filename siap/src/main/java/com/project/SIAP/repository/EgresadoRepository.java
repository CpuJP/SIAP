package com.project.SIAP.repository;

import com.project.SIAP.entities.Egresado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EgresadoRepository extends JpaRepository<Egresado, Integer>, JpaSpecificationExecutor<Egresado> {
}