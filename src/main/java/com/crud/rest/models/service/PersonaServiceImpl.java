package com.crud.rest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.rest.exceptions.BadRequestException;
import com.crud.rest.exceptions.NotFoundException;
import com.crud.rest.models.dao.PersonaDao;
import com.crud.rest.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	PersonaDao personaDao;

	@Override
	public List<Persona> buscarPersonas() {
		return personaDao.findAll();
	}

	@Override
	public Persona buscarPersonaPorId(Long id) {
		Persona persona = personaDao.findById(id).orElse(null);
		if (persona == null) {
			throw new NotFoundException("No existe la persona en la base de datos");
		}
		return persona;
	}

	@Override
	public Persona guardarPersona(Persona persona) {
		Persona nuevaPersona = personaDao.save(persona);
		if (existenLaPersona(persona.getNumeroDni())) {
			throw new BadRequestException("No pueden existir personas con el mismo numero de DNI");
		}
		if (nuevaPersona == null) {
			throw new NotFoundException("No existe la persona");
		}
		return nuevaPersona;
	}

	@Override
	public Persona actualizarPersona(Long id, Persona persona) {
		Persona personaActual = personaDao.findById(id).orElse(null);
		if (personaActual == null) {
			throw new NotFoundException("No existe la persona");
		}
		personaActual.setNombre(persona.getNombre());
		personaActual.setEdad(persona.getEdad());
		personaActual.setEmail(persona.getEmail());
		personaActual.setPais(persona.getPais());
		personaActual.setNumeroDni(persona.getNumeroDni());
		personaActual.setTelefono(persona.getTelefono());
		personaActual.setTipoDocumento(persona.getTipoDocumento());
		return personaActual;
	}

	@Override
	public void eliminarPersona(Long id) {
		personaDao.deleteById(id);
	}

	public int cantidadPersonasPorGenero(String genero) {
		List<Persona> personas = buscarPersonas();
		int personasDeGenero = 0;
		for (Persona p : personas) {
			if (p.getSexo().equals(genero)) {
				personasDeGenero++;
			}
		}
		return personasDeGenero;
	}

	public int porcentajeDeArgentinos() {
		List<Persona> personas = buscarPersonas();
		int cantidadArg = 0;
		for (Persona p : personas) {
			if (p.getPais().equals("Argentina") || p.getPais().equals("argentina")) {
				cantidadArg++;
			}
		}
		cantidadArg = cantidadArg * 100 / personas.size();
		return cantidadArg;
	}

	@Override
	public boolean existenLaPersona(String numeroDni) {
		List<Persona> personas = buscarPersonas();
		boolean existe = false;
		for (Persona p : personas) {
			if (p.getNumeroDni().equals(numeroDni)) {
				existe = true;
			}
		}
		return existe;
	}

}