package com.senescyt.app.repository;

import com.senescyt.app.model.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos,Long> {
}
