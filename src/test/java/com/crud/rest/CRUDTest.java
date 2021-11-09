package com.crud.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.rest.models.dao.PersonaDao;
import com.crud.rest.models.entity.Persona;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CRUDTest {
	
	@Autowired
    private PersonaDao personaDao;

    @Test
    @Order(1)
    public void guardarPersonaTest() {
        Persona persona = new Persona("Viejo", "20", "Argentina", "viejo@gmail.com", "1163070723", "M", "41778333", "DNI");
        assertNotNull(personaDao.save(persona));
    }
    
    @Test
    @Order(2)
    public void buscarPersonaTest() {
    	Long idPersona = 2L;
    	Persona persona = personaDao.findById(idPersona).orElse(null);
    	assertThat(persona.getId()).isEqualTo(idPersona);
    }
    
    @Test
    @Order(3)
    public void eliminarPersonaTest() {
    	Long idPersona = 2L;
    	boolean existeLaPersonaAntesDeEliminar = personaDao.findById(idPersona).isPresent();
    	personaDao.deleteById(idPersona);
    	boolean existeLaPersonaDespuesDeEliminar = personaDao.findById(idPersona).isPresent();
    	assertTrue(existeLaPersonaAntesDeEliminar);
    	assertFalse(existeLaPersonaDespuesDeEliminar);
    }

}
