package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = Docente.ENTITY_NAME)
//@Table(name = Docente.TABLE_NAME, schema = "siapprueba", indexes = {
//        @Index(name = "fk_Docentes_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
//})
public class Docente implements Serializable {
    public static final String ENTITY_NAME = "Docente";
    public static final String TABLE_NAME = "docentes";
    public static final String COLUMN_ID_NAME = "Docentescol";
    public static final String COLUMN_TIPO_NAME = "Tipo";
    public static final String COLUMN_CARGO_NAME = "Cargo";
    public static final String COLUMN_FACULTAD_NAME = "Facultad";
    public static final String COLUMN_SEDE_NAME = "Sede";
    private static final long serialVersionUID = -9024399371695546209L;


    private Integer id;

    private String tipo;

    private String cargo;

    private String facultad;

    private String sede;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Docente setId(Integer id) {
        this.id = id;
        return this;
    }

    @Lob
    @Column(name = COLUMN_TIPO_NAME, nullable = false)
    public String getTipo() {
        return tipo;
    }

    public Docente setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Lob
    @Column(name = COLUMN_CARGO_NAME, nullable = false)
    public String getCargo() {
        return cargo;
    }

    public Docente setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    @Lob
    @Column(name = COLUMN_FACULTAD_NAME, nullable = false)
    public String getFacultad() {
        return facultad;
    }

    public Docente setFacultad(String facultad) {
        this.facultad = facultad;
        return this;
    }

    @Lob
    @Column(name = COLUMN_SEDE_NAME, nullable = false)
    public String getSede() {
        return sede;
    }

    public Docente setSede(String sede) {
        this.sede = sede;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Docente setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}