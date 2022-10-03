package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.PersonalUniversidad} entity
 */
public class PersonalUniversidadDto implements Serializable {
    private final String id;
    private final String tipoDocumento;
    private final String codigo;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String correoElectronico;
    private final String celular;
    private final RfidNfcDto rfidNfcIdCarnet;

    public PersonalUniversidadDto(String id, String tipoDocumento, String codigo, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico, String celular, RfidNfcDto rfidNfcIdCarnet) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.codigo = codigo;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
        this.celular = celular;
        this.rfidNfcIdCarnet = rfidNfcIdCarnet;
    }

    public String getId() {
        return id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCelular() {
        return celular;
    }

    public RfidNfcDto getRfidNfcIdCarnet() {
        return rfidNfcIdCarnet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalUniversidadDto entity = (PersonalUniversidadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipoDocumento, entity.tipoDocumento) &&
                Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.primerNombre, entity.primerNombre) &&
                Objects.equals(this.segundoNombre, entity.segundoNombre) &&
                Objects.equals(this.primerApellido, entity.primerApellido) &&
                Objects.equals(this.segundoApellido, entity.segundoApellido) &&
                Objects.equals(this.correoElectronico, entity.correoElectronico) &&
                Objects.equals(this.celular, entity.celular) &&
                Objects.equals(this.rfidNfcIdCarnet, entity.rfidNfcIdCarnet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoDocumento, codigo, primerNombre, segundoNombre, primerApellido, segundoApellido, correoElectronico, celular, rfidNfcIdCarnet);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipoDocumento = " + tipoDocumento + ", " +
                "codigo = " + codigo + ", " +
                "primerNombre = " + primerNombre + ", " +
                "segundoNombre = " + segundoNombre + ", " +
                "primerApellido = " + primerApellido + ", " +
                "segundoApellido = " + segundoApellido + ", " +
                "correoElectronico = " + correoElectronico + ", " +
                "celular = " + celular + ", " +
                "rfidNfcIdCarnet = " + rfidNfcIdCarnet + ")";
    }
}