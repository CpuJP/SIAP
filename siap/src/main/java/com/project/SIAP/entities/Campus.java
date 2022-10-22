package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = Campus.ENTITY_NAME)
@Table(name = Campus.TABLE_NAME, indexes = {
        @Index(name = "fk_Campus_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Campus implements Serializable {
    public static final String ENTITY_NAME = "Campus";
    public static final String TABLE_NAME = "campus";
    public static final String COLUMN_ID_NAME = "Campuscol";
    public static final String COLUMN_FECHAINGRESO_NAME = "Fecha_Ingreso";
    public static final String COLUMN_FECHASALIDA_NAME = "Fecha_Salida";
    private static final long serialVersionUID = -7413250184490562684L;


    private Integer id;

    private Instant fechaIngreso;

    private Instant fechaSalida;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Campus setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_FECHAINGRESO_NAME)
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public Campus setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    @Column(name = COLUMN_FECHASALIDA_NAME)
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public Campus setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Campus setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}