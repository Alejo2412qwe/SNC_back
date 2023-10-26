package com.senescyt.app.repository;

import com.senescyt.app.model.Procesos;
import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.model.TipoInstitucion;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoInstitucionRepository extends GenericRepository<TipoInstitucion, Long> {

    @Query(value = "SELECT * FROM bd_snc.tipo_institucion where tip_estado = :est", nativeQuery = true)
    public List<TipoInstitucion> getTipoInstitucionByEstado(@Param("est") int est);

}
