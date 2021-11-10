package com.crud.rest.models.service;

import com.crud.rest.models.entity.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> buscarPersonas();

    public Persona buscarPersonaPorId(Long id);

    public Persona guardarPersona(Persona persona);

    public void eliminarPersona(Long id);

    public int cantidadPersonasPorGenero(String genero);

    public int porcentajeDeArgentinos();
    
    public boolean existenLaPersona(String numeroDni);
}
