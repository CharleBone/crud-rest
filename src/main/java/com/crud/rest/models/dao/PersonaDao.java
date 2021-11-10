package com.crud.rest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.rest.models.entity.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {
	
	@Query("SELECT COUNT(P) FROM Persona P WHERE P.sexo = :genero ")
	int personasPorGenero(@Param("genero") String genero);
	
	@Query("SELECT COUNT(P) FROM Persona P WHERE P.pais = 'Argentina' ")
	int personasDeArgentina();
	
    @Query("SELECT CASE WHEN COUNT(e.id) > 0 THEN true ELSE false END FROM Persona e WHERE e.numeroDni = :numeroDni")
    boolean buscarCoincidencia(@Param("numeroDni") String numeroDni);

}
