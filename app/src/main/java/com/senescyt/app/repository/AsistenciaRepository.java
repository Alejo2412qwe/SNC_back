package com.senescyt.app.repository;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AsistenciaRepository extends GenericRepository<Asistencia, Long> {


    @Query(nativeQuery = true, value = "SELECT   " +
            "    ROW_NUMBER() OVER (ORDER BY asis_fecha_archivo , asis_nombre_archivo, usu_id ) as indice,  " +
            "    asis_nombre_archivo,  " +
            "    asis_fecha_archivo,      " +
            "    COUNT(*) as cantidad_registros,  " +
            "    usu_id  " +
            "FROM bd_snc.asistencia  " +
            "GROUP BY asis_fecha_archivo , asis_nombre_archivo, usu_id"
    )
    List<Object[]> historialArchivos();
}
