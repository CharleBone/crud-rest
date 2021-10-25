package com.crud.rest.models.service;

import com.crud.rest.models.dao.PersonaDao;
import com.crud.rest.models.entity.Persona;
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
        return personaDao.save(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona, Long id) {
        Persona personaActual = personaDao.findById(id).orElse(null);
        return personaActual;
    }

    @Override
    public void eliminarPersona(Long id) {
        personaDao.deleteById(id);
    }

    public int cantidadHombres() {
        List<Persona> personas = buscarPersonas();
        int totalHombres = 0;
        for (Persona p : personas) {
            if (p.getSexo().equals("M")) {
                totalHombres++;
            }
        }
        return totalHombres;
    }

    public int cantidadMujeres() {
        List<Persona> personas = buscarPersonas();
        int totalMujeres = 0;
        for (Persona p : personas) {
            if (p.getSexo().equals("F")) {
                totalMujeres++;
            }
        }
        return totalMujeres;
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


}