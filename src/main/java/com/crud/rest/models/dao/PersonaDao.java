package com.crud.rest.models.dao;

import com.crud.rest.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaDao extends JpaRepository<Persona, Long> {

}
