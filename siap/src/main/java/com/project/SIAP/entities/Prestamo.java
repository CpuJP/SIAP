package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = Prestamo.ENTITY_NAME)
@Table(name = Prestamo.TABLE_NAME,  indexes = {
        @Index(name = "fk_Prestamos_Personal_Universidad1_idx", columnList = "Personal_Universidad_No_Documento")
})
public class Prestamo implements Serializable {
    public static final String ENTITY_NAME = "Prestamo";
    public static final String TABLE_NAME = "prestamos";
    public static final String COLUMN_ID_NAME = "Prestamoscol";
    public static final String COLUMN_NOMBREOBJETO_NAME = "Nombre_Objeto";
    public static final String COLUMN_FECHAINICIOPRESTAMO_NAME = "Fecha_Inicio_Prestamo";
    public static final String COLUMN_FECHAFINALPRESTAMO_NAME = "Fecha_Final_Prestamo";
    public static final String COLUMN_ORIGEN_NAME = "Origen";
    private static final long serialVersionUID = -7044895683121176254L;


    private Integer id;

    private String nombreObjeto;

    private Instant fechaInicioPrestamo;

    private Instant fechaFinalPrestamo;

    private String origen;

    private PersonalUniversidad personalUniversidadNoDocumento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    public Prestamo setId(Integer id) {
        this.id = id;
        return this;
    }

    @Column(name = COLUMN_NOMBREOBJETO_NAME, nullable = false, length = 50)
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public Prestamo setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
        return this;
    }

    @Column(name = COLUMN_FECHAINICIOPRESTAMO_NAME)
    public Instant getFechaInicioPrestamo() {
        return fechaInicioPrestamo;
    }

    public Prestamo setFechaInicioPrestamo(Instant fechaInicioPrestamo) {
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        return this;
    }

    @Column(name = COLUMN_FECHAFINALPRESTAMO_NAME)
    public Instant getFechaFinalPrestamo() {
        return fechaFinalPrestamo;
    }

    public Prestamo setFechaFinalPrestamo(Instant fechaFinalPrestamo) {
        this.fechaFinalPrestamo = fechaFinalPrestamo;
        return this;
    }

    @Lob
    @Column(name = COLUMN_ORIGEN_NAME, nullable = false)
    public String getOrigen() {
        return origen;
    }

    public Prestamo setOrigen(String origen) {
        this.origen = origen;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Personal_Universidad_No_Documento", nullable = false)
    public PersonalUniversidad getPersonalUniversidadNoDocumento() {
        return personalUniversidadNoDocumento;
    }

    public Prestamo setPersonalUniversidadNoDocumento(PersonalUniversidad personalUniversidadNoDocumento) {
        this.personalUniversidadNoDocumento = personalUniversidadNoDocumento;
        return this;
    }

}