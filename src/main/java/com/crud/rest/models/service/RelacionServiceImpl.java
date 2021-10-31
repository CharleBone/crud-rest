package com.crud.rest.models.service;

import com.crud.rest.models.dao.RelacionDao;
import com.crud.rest.models.entity.Relacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionServiceImpl implements IRelacionService{

    @Autowired
    RelacionDao relacionDao;

    @Override
    public List<Relacion> buscarRelaciones() {
        return relacionDao.findAll();
    }

    @Override
    public Relacion buscarRelacionPorId(Long id) {
        return relacionDao.findById(id).orElse(null);
    }

    @Override
    public Relacion guardarRelacion(Relacion relacion) {
        return relacionDao.save(relacion);
    }

    @Override
    public Relacion buscarRelacionAnterior(Long id) {
        List<Relacion> relaciones = relacionDao.findAll();
        Relacion relacion = null;
        for (Relacion r : relaciones) {
            if (r.getIdSecundario().equals(id)) {
                relacion =  relacionDao.findById(r.getIdRelaciones()).orElse(null);
                break;
            }
        }
        return relacion;
    }
}
