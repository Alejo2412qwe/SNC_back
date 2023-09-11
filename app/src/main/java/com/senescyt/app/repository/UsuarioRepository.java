package com.senescyt.app.repository;

import com.senescyt.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsuNombreUsuario(String usuNombreUsuario);

    boolean existsByUsuNombreUsuario(String usuNombreUsuario);

    @Query(value = "SELECT * FROM usuario u, persona p WHERE u.usu_nombre_usuario = :usuario OR p.per_correo = :email", nativeQuery = true)
    public Usuario findByUsernameOrEmail(@Param("usuario") String usuario, @Param("email") String email);

    @Query(value = "SELECT * FROM usuario WHERE usu_nombre_usuario = :usuario AND usu_contrasena = :password", nativeQuery = true)
    public boolean login(@Param("usuario") String usuario, @Param("password") String password);

}
