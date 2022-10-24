package com.project.SIAP.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Prestamo} entity
 */
public class PrestamoDto implements Serializable {
    private final Integer id;
    private final String nombreObjeto;
    private final Instant fechaInicioPrestamo;
    private final Instant fechaFinalPrestamo;
    private final String origen;

    public PrestamoDto(Integer id, String nombreObjeto, Instant fechaInicioPrestamo, Instant fechaFinalPrestamo, String origen) {
        this.id = id;
        this.nombreObjeto = nombreObjeto;
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        this.fechaFinalPrestamo = fechaFinalPrestamo;
        this.origen = origen;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public Instant getFechaInicioPrestamo() {
        return fechaInicioPrestamo;
    }

    public Instant getFechaFinalPrestamo() {
        return fechaFinalPrestamo;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestamoDto entity = (PrestamoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombreObjeto, entity.nombreObjeto) &&
                Objects.equals(this.fechaInicioPrestamo, entity.fechaInicioPrestamo) &&
                Objects.equals(this.fechaFinalPrestamo, entity.fechaFinalPrestamo) &&
                Objects.equals(this.origen, entity.origen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreObjeto, fechaInicioPrestamo, fechaFinalPrestamo, origen);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombreObjeto = " + nombreObjeto + ", " +
                "fechaInicioPrestamo = " + fechaInicioPrestamo + ", " +
                "fechaFinalPrestamo = " + fechaFinalPrestamo + ", " +
                "origen = " + origen + ")";
    }
}