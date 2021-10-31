package com.crud.rest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "relaciones")
public class Relacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelaciones;
    private Long idPrimario;
    private Long idSecundario;

    /*
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idRelaciones")
    private List<Persona> personas;

     */
    public Long getIdRelaciones() {
        return idRelaciones;
    }

    public void setIdRelaciones(Long idRelaciones) {
        this.idRelaciones = idRelaciones;
    }

    public Long getIdPrimario() {
        return idPrimario;
    }

    public void setIdPrimario(Long idPrimario) {
        this.idPrimario = idPrimario;
    }

    public Long getIdSecundario() {
        return idSecundario;
    }

    public void setIdSecundario(Long idSecundario) {
        this.idSecundario = idSecundario;
    }
 /*
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void addRelacion(Persona persona) {
        this.personas.add(persona);
    }

  */
}
