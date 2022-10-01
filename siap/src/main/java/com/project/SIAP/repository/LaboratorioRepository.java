package com.project.SIAP.repository;

import com.project.SIAP.entities.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Integer>, JpaSpecificationExecutor<Laboratorio> {
}