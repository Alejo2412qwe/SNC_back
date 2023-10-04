package com.senescyt.app.service;

import com.senescyt.app.model.Horarios;
import com.senescyt.app.model.Persona;
import com.senescyt.app.repository.HorariosRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class HorariosService extends GenericServiceImpl<Horarios, Long> implements GenericService<Horarios, Long> {

    @Autowired
    HorariosRepository horariosRepository;

    @Override
    public CrudRepository<Horarios, Long> getDao() {
        return horariosRepository;
    }
}
