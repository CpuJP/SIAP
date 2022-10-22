package com.project.SIAP.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = PersonalUniversidad.ENTITY_NAME)
@Table(name = PersonalUniversidad.TABLE_NAME, indexes = {
        @Index(name = "Celular_UNIQUE", columnList = "Celular", unique = true),
        @Index(name = "fk_Personal_Universidad_RFID_NFC_idx", columnList = "RFID_NFC_Id_Carnet"),
        @Index(name = "Codigo_UNIQUE", columnList = "Codigo", unique = true),
        @Index(name = "Correo_Electronico_UNIQUE", columnList = "Correo_Electronico", unique = true)
})
public class PersonalUniversidad implements Serializable {
    public static final String ENTITY_NAME = "Personal_Universidad";
    public static final String TABLE_NAME = "personal_universidad";
    public static final String COLUMN_ID_NAME = "No_Documento";
    public static final String COLUMN_TIPODOCUMENTO_NAME = "Tipo_Documento";
    public static final String COLUMN_CODIGO_NAME = "Codigo";
    public static final String COLUMN_PRIMERNOMBRE_NAME = "Primer_Nombre";
    public static final String COLUMN_SEGUNDONOMBRE_NAME = "Segundo_Nombre";
    public static final String COLUMN_PRIMERAPELLIDO_NAME = "Primer_Apellido";
    public static final String COLUMN_SEGUNDOAPELLIDO_NAME = "Segundo_Apellido";
    public static final String COLUMN_CORREOELECTRONICO_NAME = "Correo_Electronico";
    public static final String COLUMN_CELULAR_NAME = "Celular";
    private static final long serialVersionUID = -398252182155249677L;


    private String id;

    private String tipoDocumento;

    private String codigo;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String correoElectronico;

    private String celular;

    private RfidNfc rfidNfcIdCarnet;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false, length = 15)
    public String getId() {
        return id;
    }

    public PersonalUniversidad setId(String id) {
        this.id = id;
        return this;
    }

    @Lob
    @Column(name = COLUMN_TIPODOCUMENTO_NAME, nullable = false)
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public PersonalUniversidad setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    @Column(name = COLUMN_CODIGO_NAME, nullable = false, length = 15)
    public String getCodigo() {
        return codigo;
    }

    public PersonalUniversidad setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    @Column(name = COLUMN_PRIMERNOMBRE_NAME, nullable = false, length = 15)
    public String getPrimerNombre() {
        return primerNombre;
    }

    public PersonalUniversidad setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    @Column(name = COLUMN_SEGUNDONOMBRE_NAME, length = 15)
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public PersonalUniversidad setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    @Column(name = COLUMN_PRIMERAPELLIDO_NAME, nullable = false, length = 15)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public PersonalUniversidad setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    @Column(name = COLUMN_SEGUNDOAPELLIDO_NAME, length = 15)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public PersonalUniversidad setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    @Column(name = COLUMN_CORREOELECTRONICO_NAME, nullable = false, length = 50)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public PersonalUniversidad setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
        return this;
    }

    @Column(name = COLUMN_CELULAR_NAME, nullable = false, length = 13)
    public String getCelular() {
        return celular;
    }

    public PersonalUniversidad setCelular(String celular) {
        this.celular = celular;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RFID_NFC_Id_Carnet", nullable = false)
    public RfidNfc getRfidNfcIdCarnet() {
        return rfidNfcIdCarnet;
    }

    public PersonalUniversidad setRfidNfcIdCarnet(RfidNfc rfidNfcIdCarnet) {
        this.rfidNfcIdCarnet = rfidNfcIdCarnet;
        return this;
    }

}