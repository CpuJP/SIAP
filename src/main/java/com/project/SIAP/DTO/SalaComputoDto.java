package com.project.SIAP.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.SalaComputo} entity
 */
public class SalaComputoDto implements Serializable {
    private final Integer id;
    private final Instant fechaIngreso;
    private final Instant fechaSalida;
    private final String salaIngreso;

    public SalaComputoDto(Integer id, Instant fechaIngreso, Instant fechaSalida, String salaIngreso) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.salaIngreso = salaIngreso;
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

    public String getSalaIngreso() {
        return salaIngreso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaComputoDto entity = (SalaComputoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fechaIngreso, entity.fechaIngreso) &&
                Objects.equals(this.fechaSalida, entity.fechaSalida) &&
                Objects.equals(this.salaIngreso, entity.salaIngreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaIngreso, fechaSalida, salaIngreso);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fechaIngreso = " + fechaIngreso + ", " +
                "fechaSalida = " + fechaSalida + ", " +
                "salaIngreso = " + salaIngreso + ")";
    }
}