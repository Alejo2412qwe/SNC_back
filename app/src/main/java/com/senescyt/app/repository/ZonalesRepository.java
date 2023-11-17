package com.senescyt.app.repository;

import com.senescyt.app.model.Zonales;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonalesRepository extends GenericRepository<Zonales, Long> {

    @Query(value = "SELECT * FROM zonales WHERE zon_estado = :est", nativeQuery = true)
    List<Zonales> getZonalesByEstado(@Param("est") int est);
}
