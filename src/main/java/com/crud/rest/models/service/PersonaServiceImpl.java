package com.crud.rest.models.service;

import com.crud.rest.exceptions.BadRequestException;
import com.crud.rest.models.dao.PersonaDao;
import com.crud.rest.models.entity.Persona;

import net.bytebuddy.implementation.bytecode.Throw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
    	if (existenLaPersona(persona.getNumeroDni())) {
    		throw new BadRequestException("No pueden existir personas con el mismo numero de DNI");
    	}
        return personaDao.save(persona);
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
		for(Persona p : personas) {
			if(p.getNumeroDni().equals(numeroDni)) {
				existe = true;
			}
		}
		return existe;
	}


}