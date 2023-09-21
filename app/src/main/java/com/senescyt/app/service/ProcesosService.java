package com.senescyt.app.service;

import com.senescyt.app.model.Persona;
import com.senescyt.app.model.Procesos;
import com.senescyt.app.repository.ProcesosRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcesosService extends GenericServiceImpl<Procesos, Long> implements GenericService<Procesos, Long> {
    @Autowired
    ProcesosRepository procesosRepository;

    @Override
    public CrudRepository<Procesos, Long> getDao() {
        return procesosRepository;
    }
}
