package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.Administrativo} entity
 */
public class AdministrativoDto implements Serializable {
    private final Integer id;
    private final String cargo;
    private final String sede;
    private final PersonalUniversidadDto personalUniversidadNoDocumento;

    public AdministrativoDto(Integer id, String cargo, String sede, PersonalUniversidadDto personalUniversidadNoDocumento) {
        this.id = id;
        this.cargo = cargo;
        this.sede = sede;
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
    }

    public Integer getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSede() {
        return sede;
    }

    public PersonalUniversidadDto getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativoDto entity = (AdministrativoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cargo, entity.cargo) &&
                Objects.equals(this.sede, entity.sede) &&
                Objects.equals(this.personalUniversidadNoDocumento, entity.personalUniversidadNoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargo, sede, personalUniversidadNoDocumento);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cargo = " + cargo + ", " +
                "sede = " + sede + ", " +
                "personalUniversidadNoDocumento = " + personalUniversidadNoDocumento + ")";
    }
}