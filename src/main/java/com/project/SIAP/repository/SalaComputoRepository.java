package com.project.SIAP.repository;

import com.project.SIAP.entities.SalaComputo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalaComputoRepository extends JpaRepository<SalaComputo, Integer>, JpaSpecificationExecutor<SalaComputo> {
}