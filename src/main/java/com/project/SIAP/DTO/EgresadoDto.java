package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Egresado} entity
 */
public class EgresadoDto implements Serializable {
    private final Integer id;
    private final String facultad;
    private final String carrera;
    private final String añoProm;

    public EgresadoDto(Integer id, String facultad, String carrera, String añoProm) {
        this.id = id;
        this.facultad = facultad;
        this.carrera = carrera;
        this.añoProm = añoProm;
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

    public String getAñoProm() {
        return añoProm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EgresadoDto entity = (EgresadoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.facultad, entity.facultad) &&
                Objects.equals(this.carrera, entity.carrera) &&
                Objects.equals(this.añoProm, entity.añoProm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultad, carrera, añoProm);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "facultad = " + facultad + ", " +
                "carrera = " + carrera + ", " +
                "añoProm = " + añoProm + ")";
    }
}