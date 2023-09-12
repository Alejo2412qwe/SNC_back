package com.senescyt.app.repository;

import com.senescyt.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario u, Rol p WHERE u.usu_nombre_usuario = :usuario OR p.per_correo = :email", nativeQuery = true)
    public Usuario findByUsernameOrEmail(@Param("usuario") String usuario, @Param("email") String email);

    @Query(value = "SELECT COUNT(*) FROM usuario WHERE usu_nombre_usuario = :usuario", nativeQuery = true)
    int usuarioUnico(@Param("usuario") String usuario);

    @Query(value = "SELECT * FROM usuario WHERE usu_nombre_usuario = :usuario AND usu_contrasena = :password", nativeQuery = true)
    public Usuario login(@Param("usuario") String usuario, @Param("password") String password);

    @Query(value = "SELECT * FROM usuario WHERE usu_correo =: email",nativeQuery = true)
    public Usuario findByUsuCorreo(@Param("email") String email);

    @Query(value = "SELECT * FROM usuario WHERE usu_token_password =: token",nativeQuery = true)
    public Usuario findByUsuTokenPassword(@Param("token") String token);

    Optional<Usuario> findByUsuNombreUsuario(String usuNombreUsuario);

    boolean existsByUsuNombreUsuario(String usuNombreUsuario);



}
