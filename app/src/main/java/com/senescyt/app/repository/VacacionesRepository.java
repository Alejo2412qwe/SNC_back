package com.senescyt.app.repository;

import com.senescyt.app.model.Vacaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacacionesRepository extends JpaRepository<Vacaciones,Long> {
}
