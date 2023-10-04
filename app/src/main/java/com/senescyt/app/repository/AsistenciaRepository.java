package com.senescyt.app.repository;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends GenericRepository<Asistencia, Long> {
}
