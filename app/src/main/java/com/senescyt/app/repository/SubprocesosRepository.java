package com.senescyt.app.repository;

import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubprocesosRepository extends GenericRepository<Subprocesos, Long> {

    @Query(value = "SELECT sub. FROM Subprocesos sub JOIN Procesos proc ON sub.procId = proc.procId WHERE proc.procId = :idSubproceso;", nativeQuery = true)
    Subprocesos getSubprocesosByProcId(@Param("idSubproceso") Long idSubproceso);
}
