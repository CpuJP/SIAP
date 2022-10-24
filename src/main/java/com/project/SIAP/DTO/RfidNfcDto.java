package com.project.SIAP.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.project.SIAP.entities.RfidNfc} entity
 */
public class RfidNfcDto implements Serializable {
    private final String id;

    public RfidNfcDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RfidNfcDto entity = (RfidNfcDto) o;
        return Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")";
    }
}