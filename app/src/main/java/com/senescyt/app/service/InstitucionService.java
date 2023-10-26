package com.senescyt.app.service;

import com.senescyt.app.model.Institucion;
import com.senescyt.app.model.Persona;
import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.repository.InsitucionRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService extends GenericServiceImpl<Institucion, Long> implements GenericService<Institucion, Long> {

    @Autowired
    InsitucionRepository insitucionRepository;

    @Override
    public CrudRepository<Institucion, Long> getDao() {
        return insitucionRepository;
    }


    public List<Institucion> getInstitucionByTipId(Long tipId) {
        return insitucionRepository.getInstitucionByTipId(tipId);
    }
}
