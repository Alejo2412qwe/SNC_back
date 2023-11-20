package com.senescyt.app.repository;

import com.senescyt.app.model.Vacaciones;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacacionesRepository extends GenericRepository<Vacaciones,Long> {
    @Query(value = "SELECT * FROM horarios where vacEstado = :est", nativeQuery = true)
    public List<Vacaciones> getVacacionesByEstado(@Param("est") int est);
}
