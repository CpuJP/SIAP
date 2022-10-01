package com.project.SIAP.repository;

import com.project.SIAP.entities.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>, JpaSpecificationExecutor<Biblioteca> {
}