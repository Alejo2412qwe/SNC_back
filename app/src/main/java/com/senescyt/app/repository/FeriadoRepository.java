package com.senescyt.app.repository;

import com.senescyt.app.model.Feriado;
import com.senescyt.app.model.Zonales;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeriadoRepository extends GenericRepository<Feriado,Long> {

    @Query(value = "SELECT * FROM feriado WHERE fer_id = :id", nativeQuery = true)
    Feriado getFeriadosById(@Param("id") Long id);

    @Query(value = "SELECT * FROM feriado WHERE fer_estado = :est", nativeQuery = true)
    List<Feriado> getFeriadosByEstado(@Param("est") int est);

}
