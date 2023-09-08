/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senescyt.app.repository;

import com.senescyt.app.model.Persona;
import com.senescyt.app.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ALEJO PC
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT COUNT(*) FROM Rol WHERE per_cedula = :cedulaRol", nativeQuery = true)
    int contarCedulas(@Param("cedulaRol") String cedulaRol);
}
