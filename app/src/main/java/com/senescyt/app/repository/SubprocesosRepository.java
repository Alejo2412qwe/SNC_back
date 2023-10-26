package com.senescyt.app.repository;

import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubprocesosRepository extends GenericRepository<Subprocesos, Long> {

    @Query(value = "SELECT * FROM subprocesos where proc_id = :idSubproceso", nativeQuery = true)
    List<Subprocesos> getSubprocesosByProcId(@Param("idSubproceso") Long idSubproceso);
}
