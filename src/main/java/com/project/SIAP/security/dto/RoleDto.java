package com.project.SIAP.security.dto;

import com.project.SIAP.security.entities.Role;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final long id;
    private final String name;
    private final String description;
}