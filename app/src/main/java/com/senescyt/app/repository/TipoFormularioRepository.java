package com.senescyt.app.repository;

import com.senescyt.app.model.TipoFormulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFormularioRepository extends JpaRepository<TipoFormulario,Long> {
}
