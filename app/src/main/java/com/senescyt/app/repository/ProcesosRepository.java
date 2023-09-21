package com.senescyt.app.repository;

import com.senescyt.app.model.Procesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesosRepository extends JpaRepository<Procesos,Long> {
}
