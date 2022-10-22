package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = Estudiante.ENTITY_NAME)
@Table(name = Estudiante.TABLE_NAME,  indexes = {
        @Index(name = "fk_Estudiantes_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Estudiante implements Serializable {
    public static final String ENTITY_NAME = "Estudiante";
    public static final String TABLE_NAME = "estudiantes";
    public static final String COLUMN_ID_NAME = "Estudiantescol";
    public static final String COLUMN_FACULTAD_NAME = "Facultad";
    public static final String COLUMN_CARRERA_NAME = "Carrera";
    public static final String COLUMN_SEMESTRE_NAME = "Semestre";
    public static final String COLUMN_SEDE_NAME = "Sede";
    private static final long serialVersionUID = -2570835126189496652L;


    private Integer id;

    private String facultad;

    private String carrera;

    private Integer semestre;

    private String sede;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Estudiante setId(Integer id) {
        this.id = id;
        return this;
    }

    @Lob
    @Column(name = COLUMN_FACULTAD_NAME, nullable = false)
    public String getFacultad() {
        return facultad;
    }

    public Estudiante setFacultad(String facultad) {
        this.facultad = facultad;
        return this;
    }

    @Lob
    @Column(name = COLUMN_CARRERA_NAME, nullable = false)
    public String getCarrera() {
        return carrera;
    }

    public Estudiante setCarrera(String carrera) {
        this.carrera = carrera;
        return this;
    }

    @Column(name = COLUMN_SEMESTRE_NAME, nullable = false)
    public Integer getSemestre() {
        return semestre;
    }

    public Estudiante setSemestre(Integer semestre) {
        this.semestre = semestre;
        return this;
    }

    @Lob
    @Column(name = COLUMN_SEDE_NAME, nullable = false)
    public String getSede() {
        return sede;
    }

    public Estudiante setSede(String sede) {
        this.sede = sede;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Estudiante setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}