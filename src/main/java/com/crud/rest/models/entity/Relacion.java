package com.crud.rest.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "relaciones")
public class Relacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idPrimario;
    private Integer idSecundario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPrimario() {
        return idPrimario;
    }

    public void setIdPrimario(Integer idPrimario) {
        this.idPrimario = idPrimario;
    }

    public Integer getIdSecundario() {
        return idSecundario;
    }

    public void setIdSecundario(Integer idSecundario) {
        this.idSecundario = idSecundario;
    }
}
