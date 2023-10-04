package com.senescyt.app.repository;

import com.senescyt.app.model.Institucion;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsitucionRepository extends GenericRepository<Institucion,Long> {
}
