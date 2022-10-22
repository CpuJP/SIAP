package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = Laboratorio.ENTITY_NAME)
@Table(name = Laboratorio.TABLE_NAME,  indexes = {
        @Index(name = "fk_Laboratorio_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Laboratorio implements Serializable {
    public static final String ENTITY_NAME = "Laboratorio";
    public static final String TABLE_NAME = "laboratorio";
    public static final String COLUMN_ID_NAME = "Laboratoriocol";
    public static final String COLUMN_FECHAINGRESO_NAME = "Fecha_Ingreso";
    public static final String COLUMN_FECHASALIDA_NAME = "Fecha_Salida";
    private static final long serialVersionUID = -2074502216147998741L;


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

    public Laboratorio setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_FECHAINGRESO_NAME)
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public Laboratorio setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    @Column(name = COLUMN_FECHASALIDA_NAME)
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public Laboratorio setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Laboratorio setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}