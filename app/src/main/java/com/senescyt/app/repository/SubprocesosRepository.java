package com.senescyt.app.repository;

import com.senescyt.app.model.Subprocesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubprocesosRepository extends JpaRepository<Subprocesos,Long> {
}
