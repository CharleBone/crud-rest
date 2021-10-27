package com.crud.rest.models.dao;

import com.crud.rest.models.entity.Relacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacionDao extends JpaRepository<Relacion, Long> {
}
