package com.project.SIAP.repository;

import com.project.SIAP.entities.RfidNfc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RfidNfcRepository extends JpaRepository<RfidNfc, String>, JpaSpecificationExecutor<RfidNfc> {
}