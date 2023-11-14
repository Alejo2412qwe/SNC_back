package com.senescyt.app.repository;

import com.senescyt.app.model.Periodo;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoRepository extends GenericRepository<Periodo,Long> {

    @Query(value = "SELECT * FROM periodo where peri_estado = :est", nativeQuery = true)
    public List<Periodo> getPeriodoByEstado(@Param("est") int est);
}
