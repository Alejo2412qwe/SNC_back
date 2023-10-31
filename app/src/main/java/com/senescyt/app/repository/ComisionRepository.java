package com.senescyt.app.repository;

import com.senescyt.app.model.Comision;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComisionRepository extends GenericRepository<Comision,Long> {
    @Query(value = "SELECT * FROM horarios where comEstado = :est", nativeQuery = true)
    public List<Comision> getComisionByEstado(@Param("est") int est);
}
