package com.senescyt.app.contoller;

import com.senescyt.app.model.Permisos;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        p.setPermEstado(3);
        Date date = new Date();
        Date fechahoy = new Date(date.getTime());
        p.setPermFechaEmision(fechahoy);
        return new ResponseEntity<>(permisosService.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/getPermisosByUsuId")
    public ResponseEntity<List<Permisos>> getPermisosByUsuId(@RequestParam int id) {
        return new ResponseEntity<>(permisosService.getPermisosByUsuId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Permisos> update(@RequestParam Long id, @RequestBody String p) {

        Permisos permisos = permisosService.findById(id);
        if (permisos != null) {
            try {
                permisos.setPermDocumento(p);
                permisosService.save(permisos);
                return new ResponseEntity<>(permisos, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEst")
    public ResponseEntity<Permisos> updateEst(@RequestParam Long id, @RequestParam int est) {
        Permisos permisos = permisosService.findById(id);
        if (permisos != null) {
            try {

                permisos.setPermEstado(est);
                permisosService.save(permisos);
                return new ResponseEntity<>(HttpStatus.OK);
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
