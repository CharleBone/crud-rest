package com.crud.rest.models.service;

import com.crud.rest.models.entity.Relacion;


public interface IRelacionService {

    public Relacion buscarRelacionPorId(Long id);

    public Relacion guardarRelacion(Relacion relacion);
}
