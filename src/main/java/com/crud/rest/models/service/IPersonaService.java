package com.crud.rest.models.service;

import java.util.List;

import com.crud.rest.models.entity.Persona;

public interface IPersonaService {

	public List<Persona> buscarPersonas();

	public Persona buscarPersonaPorId(Long id);

	public Persona guardarPersona(Persona persona);

	public void actualizarPersona(Long id, Persona persona);

	public void eliminarPersona(Long id);

	public int cantidadPersonasPorGenero(String genero);

	public int porcentajeDeArgentinos();

	public boolean existenLaPersona(String numeroDni);
}
