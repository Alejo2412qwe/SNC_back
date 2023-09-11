package com.senescyt.app.repository;

import com.senescyt.app.model.ipPermitidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ipRepository extends JpaRepository<ipPermitidas, Long> {

}
