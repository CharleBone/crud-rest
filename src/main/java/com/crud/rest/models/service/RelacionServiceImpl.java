package com.crud.rest.models.service;

import com.crud.rest.models.dao.RelacionDao;
import com.crud.rest.models.entity.Relacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelacionServiceImpl implements IRelacionService{

    @Autowired
    RelacionDao relacionDao;

    @Override
    public Relacion buscarRelacionPorId(Long id) {
        return relacionDao.findById(id).orElse(null);
    }

    @Override
    public Relacion guardarRelacion(Relacion relacion) {
        return relacionDao.save(relacion);
    }
}
