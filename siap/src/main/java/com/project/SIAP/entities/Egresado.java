package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = Egresado.ENTITY_NAME)
@Table(name = Egresado.TABLE_NAME, indexes = {
        @Index(name = "fk_Egresado_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Egresado implements Serializable {
    public static final String ENTITY_NAME = "Egresado";
    public static final String TABLE_NAME = "egresado";
    public static final String COLUMN_ID_NAME = "Egresadocol";
    public static final String COLUMN_FACULTAD_NAME = "Facultad";
    public static final String COLUMN_CARRERA_NAME = "Carrera";
    public static final String COLUMN_AÑOPROM_NAME = "`Año_Prom`";
    private static final long serialVersionUID = 6288838575690738899L;


    private Integer id;

    private String facultad;

    private String carrera;

    private String añoProm;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Egresado setId(Integer id) {
        this.id = id;
        return this;
    }

    @Lob
    @Column(name = COLUMN_FACULTAD_NAME, nullable = false)
    public String getFacultad() {
        return facultad;
    }

    public Egresado setFacultad(String facultad) {
        this.facultad = facultad;
        return this;
    }

    @Lob
    @Column(name = COLUMN_CARRERA_NAME, nullable = false)
    public String getCarrera() {
        return carrera;
    }

    public Egresado setCarrera(String carrera) {
        this.carrera = carrera;
        return this;
    }

    @Column(name = COLUMN_AÑOPROM_NAME, nullable = false, length = 8)
    public String getAñoProm() {
        return añoProm;
    }

    public Egresado setAñoProm(String añoProm) {
        this.añoProm = añoProm;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Egresado setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}