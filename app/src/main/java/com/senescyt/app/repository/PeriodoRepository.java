package com.senescyt.app.repository;

import com.senescyt.app.model.Periodo;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends GenericRepository<Periodo,Long> {
}
