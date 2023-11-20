package com.senescyt.app.service;


import com.senescyt.app.model.Asistencia;
import com.senescyt.app.repository.AsistenciaRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AsistenciaService extends GenericServiceImpl<Asistencia, Long> implements GenericService<Asistencia, Long> {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public CrudRepository<Asistencia, Long> getDao() {
        return asistenciaRepository;
    }

    public List<Asistencia> saveAll(List<Asistencia> asistencias) {
        return (List<Asistencia>) asistenciaRepository.saveAll(asistencias);
    }

    public List<Object[]> historialArchivos() {
        return asistenciaRepository.historialArchivos();
    }

    public List<Object[]> historialArchivosSearch(String fechaMin, String fechaMax, String nombre) {
        return asistenciaRepository.historialArchivosSearch(fechaMin, fechaMax, nombre);
    }
}
