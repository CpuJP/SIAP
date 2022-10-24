package com.project.SIAP.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Laboratorio} entity
 */
public class LaboratorioDto implements Serializable {
    private final Integer id;
    private final Instant fechaIngreso;
    private final Instant fechaSalida;

    public LaboratorioDto(Integer id, Instant fechaIngreso, Instant fechaSalida) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public Integer getId() {
        return id;
    }

    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public Instant getFechaSalida() {
        return fechaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaboratorioDto entity = (LaboratorioDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fechaIngreso, entity.fechaIngreso) &&
                Objects.equals(this.fechaSalida, entity.fechaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaIngreso, fechaSalida);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fechaIngreso = " + fechaIngreso + ", " +
                "fechaSalida = " + fechaSalida + ")";
    }
}