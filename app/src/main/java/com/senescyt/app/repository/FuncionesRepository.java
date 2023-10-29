package com.senescyt.app.repository;

import com.senescyt.app.model.Funciones;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionesRepository extends GenericRepository<Funciones,Long> {

    @Query(value = "SELECT * FROM funciones where fun_estado = :est", nativeQuery = true)
    public List<Funciones> getFuncionesByEstado(@Param("est") int est);

}
