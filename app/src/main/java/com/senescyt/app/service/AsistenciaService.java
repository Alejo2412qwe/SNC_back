package com.senescyt.app.service;


import com.senescyt.app.model.Asistencia;
import com.senescyt.app.repository.AsistenciaRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService extends GenericServiceImpl<Asistencia, Long> implements GenericService<Asistencia, Long> {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public CrudRepository<Asistencia, Long> getDao() {
        return asistenciaRepository;
    }
}
