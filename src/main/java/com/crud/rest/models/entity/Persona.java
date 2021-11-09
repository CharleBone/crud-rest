package com.crud.rest.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 269308710402193214L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Min(value = 18, message = "No puede registrar personas menores de 18 años")
    private String edad;
    @NotEmpty
    private String pais;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String sexo;
    @NotEmpty
    private String numeroDni;
    @NotEmpty
    private String tipoDocumento;
    
    public Persona(@NotEmpty String nombre,
			@NotEmpty @Min(value = 18, message = "No puede registrar personas menores de 18 años") String edad,
			@NotEmpty String pais, @NotEmpty @Email String email, @NotEmpty String telefono, @NotEmpty String sexo,
			@NotEmpty String numeroDni, @NotEmpty String tipoDocumento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.pais = pais;
		this.email = email;
		this.telefono = telefono;
		this.sexo = sexo;
		this.numeroDni = numeroDni;
		this.tipoDocumento = tipoDocumento;
	}
    
    public Persona() {}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
