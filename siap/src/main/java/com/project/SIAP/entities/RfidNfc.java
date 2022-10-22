package com.project.SIAP.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = RfidNfc.ENTITY_NAME)
@Table(name = RfidNfc.TABLE_NAME)
public class RfidNfc implements Serializable {
    public static final String ENTITY_NAME = "Rfid_Nfc";
    public static final String TABLE_NAME = "rfid_nfc";
    public static final String COLUMN_ID_NAME = "Id_Carnet";
    private static final long serialVersionUID = 8958415120676300116L;

    private String id;

    @Id
    @Column(name = COLUMN_ID_NAME, nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public RfidNfc setId(String id) {
        this.id = id;
        return this;
    }

    //TODO [JPA Buddy] generate columns from DB
}