package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Docente} entity
 */
public class DocenteDto implements Serializable {
    private final Integer id;
    private final String tipo;
    private final String cargo;
    private final String facultad;
    private final String sede;

    public DocenteDto(Integer id, String tipo, String cargo, String facultad, String sede) {
        this.id = id;
        this.tipo = tipo;
        this.cargo = cargo;
        this.facultad = facultad;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getSede() {
        return sede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocenteDto entity = (DocenteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipo, entity.tipo) &&
                Objects.equals(this.cargo, entity.cargo) &&
                Objects.equals(this.facultad, entity.facultad) &&
                Objects.equals(this.sede, entity.sede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, cargo, facultad, sede);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipo = " + tipo + ", " +
                "cargo = " + cargo + ", " +
                "facultad = " + facultad + ", " +
                "sede = " + sede + ")";
    }
}