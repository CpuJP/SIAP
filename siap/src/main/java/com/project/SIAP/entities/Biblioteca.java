package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = Biblioteca.ENTITY_NAME)
@Table(name = Biblioteca.TABLE_NAME,  indexes = {
        @Index(name = "fk_Biblioteca_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Biblioteca implements Serializable {
    public static final String ENTITY_NAME = "Biblioteca";
    public static final String TABLE_NAME = "biblioteca";
    public static final String COLUMN_ID_NAME = "Bibliotecacol";
    public static final String COLUMN_FECHAINGRESO_NAME = "Fecha_Ingreso";
    public static final String COLUMN_FECHASALIDA_NAME = "Fecha_Salida";
    private static final long serialVersionUID = -1042978103405538879L;


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

    public Biblioteca setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_FECHAINGRESO_NAME)
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public Biblioteca setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    @Column(name = COLUMN_FECHASALIDA_NAME)
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public Biblioteca setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Biblioteca setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}