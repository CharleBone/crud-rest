package com.crud.rest.models.service;

import com.crud.rest.models.entity.Relacion;

import java.util.List;


public interface IRelacionService {

    public List<Relacion> buscarRelaciones();

    public Relacion buscarRelacionPorId(Long id);

    public Relacion guardarRelacion(Relacion relacion);

    public Relacion buscarRelacionAnterior(Long id);
}
