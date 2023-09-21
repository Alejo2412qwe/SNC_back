package com.senescyt.app.repository;

import com.senescyt.app.model.CargoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoUsuarioRepository extends JpaRepository<CargoUsuario,Long> {
}
