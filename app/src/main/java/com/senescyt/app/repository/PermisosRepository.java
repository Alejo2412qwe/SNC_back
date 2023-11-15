package com.senescyt.app.repository;

import com.senescyt.app.model.Permisos;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisosRepository extends GenericRepository<Permisos, Long> {

    @Query(value = "SELECT * FROM permisos WHERE usu_id = :id", nativeQuery = true)
    List<Permisos> getPermisosByUsuId(@Param("id") int id);

    @Query(value = "SELECT p.* FROM permisos p JOIN usuario u ON p.usu_id = u.usu_id WHERE u.usu_id_jefe = :id", nativeQuery = true)
    List<Permisos> getPermisosByIdJefe(@Param("id") int id);
}
