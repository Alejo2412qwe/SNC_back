package com.senescyt.app.service;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.model.TipoPermiso;
import com.senescyt.app.repository.TipoPermisoRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoPermisoService extends GenericServiceImpl<TipoPermiso, Long> implements GenericService<TipoPermiso, Long> {
    @Autowired
    TipoPermisoRepository tipoPermisoRepository;

    @Override
    public CrudRepository<TipoPermiso, Long> getDao() {
        return tipoPermisoRepository;
    }
}
