package com.project.SIAP.repository;

import com.project.SIAP.entities.PersonalUniversidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonalUniversidadRepository extends JpaRepository<PersonalUniversidad, String>, JpaSpecificationExecutor<PersonalUniversidad> {
}