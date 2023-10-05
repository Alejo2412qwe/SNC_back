package com.senescyt.app.contoller;

import com.senescyt.app.model.Permisos;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/permisos")
public class PermisosController {
    @Autowired
    private PermisoService permisosService;

    @GetMapping("/read")
    public ResponseEntity<List<Permisos>> read() {
        return new ResponseEntity<>(permisosService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Permisos> create(@RequestBody Permisos p) {
        return new ResponseEntity<>(permisosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Permisos> update(@PathVariable Long id, @RequestBody Permisos p) {
        Permisos Permisos = permisosService.findById(id);
        if (Permisos != null) {
            try {

                Permisos.setPermCondicion(p.getPermCondicion());
                Permisos.setPermEstado(p.isPermEstado());
                Permisos.setPermDocumento(p.getPermDocumento());
                Permisos.setPermFecha(p.getPermFecha());
                Permisos.setPermNumHoras(p.getPermNumHoras());
                Permisos.setPermTipo(p.getPermTipo());
                Permisos.setPermDocumento(p.getPermDocumento());

                return new ResponseEntity<>(permisosService.save(Permisos), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        permisosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
