package com.senescyt.app.service;

import com.senescyt.app.model.Rol;
import com.senescyt.app.repository.RolRepository;
import com.senescyt.app.repository.genericService.GenericService;
import com.senescyt.app.repository.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolService extends GenericServiceImpl<Rol, Long> implements GenericService<Rol, Long> {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolRepository;
    }

}
