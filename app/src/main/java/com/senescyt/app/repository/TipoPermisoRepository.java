package com.senescyt.app.repository;

import com.senescyt.app.model.TipoPermiso;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPermisoRepository extends GenericRepository<TipoPermiso,Long> {
}
