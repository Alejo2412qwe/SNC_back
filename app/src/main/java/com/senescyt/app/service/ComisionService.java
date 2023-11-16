package com.senescyt.app.service;

import com.senescyt.app.model.Comision;
import com.senescyt.app.model.Vacaciones;
import com.senescyt.app.repository.ComisionRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisionService extends GenericServiceImpl<Comision, Long> implements GenericService<Comision, Long> {
    @Autowired
    ComisionRepository comisionRepository;

    @Override
    public CrudRepository<Comision, Long> getDao() {
        return comisionRepository;
    }

    public List<Comision> getComisionByEst(int est) {
        return comisionRepository.getComisionByEstado(est);
    }
}