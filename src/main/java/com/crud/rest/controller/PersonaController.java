package com.crud.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.exceptions.InvalidDataException;
import com.crud.rest.models.entity.Persona;
import com.crud.rest.models.service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/personas")
	public List<Persona> listar() {
		return personaService.buscarPersonas();
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity<?> mostrarPersona(@PathVariable() Long id) {
		Persona persona = null;
		Map<String, Object> response = new HashMap<>();
		persona = personaService.buscarPersonaPorId(id);
		response.put("persona", persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@PostMapping("/personas")
	public ResponseEntity<?> guardarPersona(@Valid @RequestBody() Persona persona, BindingResult result) {
		Persona nuevaPersona = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		nuevaPersona = personaService.guardarPersona(persona);
		response.put("mensaje", "Se guardo correctamente");
		response.put("persona", nuevaPersona);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/personas/{id}")
	public ResponseEntity<?> actualizarPersona(@Valid @RequestBody Persona persona, BindingResult result,
			@PathVariable() Long id) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		personaService.actualizarPersona(id, persona);
		response.put("mensaje", "El cliente ha sido actualizado satifactoriamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable() Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			personaService.eliminarPersona(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al buscar al cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se elimino correctamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/estadisticas")
	public ResponseEntity<?> estadisticasTotales() {
		Map<String, Object> response = new HashMap<>();
		response.put("cantidad_hombres", personaService.cantidadPersonasPorGenero("M"));
		response.put("cantidad_mujeres", personaService.cantidadPersonasPorGenero("F"));
		response.put("porcentaje_argentinos", personaService.porcentajeDeArgentinos());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}