package com.senescyt.app.repository;

import com.senescyt.app.model.Institucion;
import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsitucionRepository extends GenericRepository<Institucion,Long> {

    @Query(value = "SELECT * FROM institucion where tip_id = :tipId", nativeQuery = true)
    List<Institucion> getInstitucionByTipId(@Param("tipId") Long tipId);
}
