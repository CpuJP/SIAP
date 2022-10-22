package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = SalaComputo.ENTITY_NAME)
//@Table(name = SalaComputo.TABLE_NAME, schema = "siapprueba", indexes = {
//        @Index(name = "fk_Sala Computo_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
//})
public class SalaComputo implements Serializable {
    public static final String ENTITY_NAME = "Sala_Computo";
    public static final String TABLE_NAME = "`sala computo`";
    public static final String COLUMN_ID_NAME = "`Sala Computocol`";
    public static final String COLUMN_FECHAINGRESO_NAME = "Fecha_Ingreso";
    public static final String COLUMN_FECHASALIDA_NAME = "Fecha_Salida";
    public static final String COLUMN_SALAINGRESO_NAME = "Sala_Ingreso";
    private static final long serialVersionUID = 1558161001339482924L;


    private Integer id;

    private Instant fechaIngreso;

    private Instant fechaSalida;

    private String salaIngreso;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public SalaComputo setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_FECHAINGRESO_NAME)
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public SalaComputo setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    @Column(name = COLUMN_FECHASALIDA_NAME)
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public SalaComputo setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    @Column(name = COLUMN_SALAINGRESO_NAME, nullable = false, length = 5)
    public String getSalaIngreso() {
        return salaIngreso;
    }

    public SalaComputo setSalaIngreso(String salaIngreso) {
        this.salaIngreso = salaIngreso;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public SalaComputo setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}