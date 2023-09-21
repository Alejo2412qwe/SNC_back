package com.senescyt.app.repository;

import com.senescyt.app.model.TipoInstitucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInstitucionRepository extends JpaRepository<TipoInstitucion,Long> {
}
