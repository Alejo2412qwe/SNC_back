package com.senescyt.app.repository;

import com.senescyt.app.model.Ciudad;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends GenericRepository<Ciudad,Long> {
}
