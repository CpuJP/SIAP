package com.project.SIAP.repository;

import com.project.SIAP.entities.PersonalUniversidad;
import com.project.SIAP.entities.RfidNfc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PersonalUniversidadRepository extends JpaRepository<PersonalUniversidad, String>, JpaSpecificationExecutor<PersonalUniversidad> {

    @Transactional(readOnly = true)
    Optional<PersonalUniversidad> findByRfidNfcIdCarnet(RfidNfc rfidNfc);

    @Transactional(readOnly = true)
    Optional<PersonalUniversidad> findByCelular(String celular);
}