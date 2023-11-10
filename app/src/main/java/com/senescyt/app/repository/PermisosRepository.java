package com.senescyt.app.repository;

import com.senescyt.app.model.Permisos;
import com.senescyt.app.model.TipoFormulario;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisosRepository extends GenericRepository<Permisos, Long> {

    @Query(value = "SELECT * FROM permisos WHERE usu_id = :id", nativeQuery = true)
    List<Permisos> getPermisosByUsuId(@Param("id") int id);
}
