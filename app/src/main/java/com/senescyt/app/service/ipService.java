package com.senescyt.app.service;

import com.senescyt.app.model.ipPermitidas;
import com.senescyt.app.repository.ipRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ipService extends GenericServiceImpl<ipPermitidas, Long> implements GenericService<ipPermitidas, Long> {

    @Autowired
    private ipRepository ipRepository;

    @Override
    public CrudRepository<ipPermitidas, Long> getDao() {
        return ipRepository;
    }
}
