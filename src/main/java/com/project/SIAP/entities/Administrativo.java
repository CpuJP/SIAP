package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = Administrativo.ENTITY_NAME)
@Table(name = Administrativo.TABLE_NAME, indexes = {
        @Index(name = "fk_Administrativo_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Administrativo implements Serializable {
    public static final String ENTITY_NAME = "Administrativo";
    public static final String TABLE_NAME = "administrativo";
    public static final String COLUMN_ID_NAME = "Administrativocol";
    public static final String COLUMN_CARGO_NAME = "Cargo";
    public static final String COLUMN_SEDE_NAME = "Sede";
    private static final long serialVersionUID = -8417199825247084553L;


    private Integer id;

    private String cargo;

    private String sede;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Administrativo setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_CARGO_NAME, nullable = false, length = 45)
    public String getCargo() {
        return cargo;
    }

    public Administrativo setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    @Lob
    @Column(name = COLUMN_SEDE_NAME, nullable = false)
    public String getSede() {
        return sede;
    }

    public Administrativo setSede(String sede) {
        this.sede = sede;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Administrativo setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}