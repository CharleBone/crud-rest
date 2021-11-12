package com.crud.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.rest.models.entity.Persona;
import com.crud.rest.models.service.IPersonaService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonaServiceTests {
	
	@Autowired
    private IPersonaService personaService;
	
    @Test
    public void buscarPersonas_listaDePersonasExistentes_retornaCincoPersonas() {
    	List<Persona> personas = personaService.buscarPersonas();
    	
    	assertThat(personas).isNotNull();
    	assertThat(personas.size()).isEqualTo(5);
    }
    
    @Test
    public void buscarPersonaPorId_PersonaExistente_retornaUnaPersona() {
    	Long idPersona = 2L;
    	Persona persona = personaService.buscarPersonaPorId(idPersona);
    	
    	assertThat(persona).isNotNull();
    	assertThat(persona.getId()).isEqualTo(idPersona);
    }
    
    @Test
    public void cantidadPersonasPorGenero_personalMasculinoExistente_retornaCincoMasculinos() {
    	int personalMasculino = personaService.cantidadPersonasPorGenero("M");
    	
    	assertThat(personalMasculino).isNotZero();
    	assertThat(personalMasculino).isNotNegative();
    	assertThat(personalMasculino).isEqualTo(5);
    	
    }
    
    @Test
    public void porcentajeDeArgentinos_retornaPorcentajeTotal() {
    	int porcentaje = personaService.porcentajeDeArgentinos();
    	
    	assertThat(porcentaje).isNotZero();
    	assertThat(porcentaje).isNotNegative();
    	assertThat(porcentaje).isEqualTo(5);
    	
    }
    
    @Test
    public void existeLaPersona_PersonaExistente_retornaPersona() {
    	String numeroDni = "41778338";
    	boolean existe = personaService.existenLaPersona(numeroDni);
    	assertThat(existe).isTrue();
    }
    

}
