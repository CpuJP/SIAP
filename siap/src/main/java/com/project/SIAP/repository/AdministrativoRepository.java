package com.project.SIAP.repository;

import com.project.SIAP.entities.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdministrativoRepository extends JpaRepository<Administrativo, Integer>, JpaSpecificationExecutor<Administrativo> {
}