package com.senescyt.app.repository;

import com.senescyt.app.model.Procesos;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcesosRepository extends GenericRepository<Procesos, Long> {

    @Query(value = "SELECT * FROM procesos where proc_estado = :est", nativeQuery = true)
    public List<Procesos> getProcesosByEstado(@Param("est") int est);
}
