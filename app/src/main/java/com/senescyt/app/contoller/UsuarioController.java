package com.senescyt.app.contoller;

import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.service.RolService;
import com.senescyt.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> read() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {

                usuario.setUsuEstado(u.getUsuEstado());
                usuario.setUsuNombreUsuario(u.getUsuNombreUsuario());
                usuario.setUsuContrasena(u.getUsuContrasena());
                usuario.setRolId(u.getRolId());
                usuario.setUsuCorreo(u.getUsuCorreo());


                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
