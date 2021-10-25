package com.crud.rest.models.service;

import com.crud.rest.models.entity.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> buscarPersonas();

    public Persona buscarPersonaPorId(Long id);

    public Persona guardarPersona(Persona persona);

    public Persona actualizarPersona(Persona persona, Long id);

    public void eliminarPersona(Long id);

    public int cantidadHombres();

    public int cantidadMujeres();

    public int porcentajeDeArgentinos();
}
