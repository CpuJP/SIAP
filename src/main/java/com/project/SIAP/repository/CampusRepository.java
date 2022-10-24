package com.project.SIAP.repository;

import com.project.SIAP.entities.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CampusRepository extends JpaRepository<Campus, Integer>, JpaSpecificationExecutor<Campus> {
}