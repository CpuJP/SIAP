package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Estudiante} entity
 */
public class EstudianteDto implements Serializable {
    private final Integer id;
    private final String facultad;
    private final String carrera;
    private final Integer semestre;
    private final String sede;

    public EstudianteDto(Integer id, String facultad, String carrera, Integer semestre, String sede) {
        this.id = id;
        this.facultad = facultad;
        this.carrera = carrera;
        this.semestre = semestre;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public String getSede() {
        return sede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteDto entity = (EstudianteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.facultad, entity.facultad) &&
                Objects.equals(this.carrera, entity.carrera) &&
                Objects.equals(this.semestre, entity.semestre) &&
                Objects.equals(this.sede, entity.sede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultad, carrera, semestre, sede);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "facultad = " + facultad + ", " +
                "carrera = " + carrera + ", " +
                "semestre = " + semestre + ", " +
                "sede = " + sede + ")";
    }
}