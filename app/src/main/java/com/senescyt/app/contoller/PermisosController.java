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
        p.setPermEstado('E');
        return new ResponseEntity<>(permisosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Permisos> update(@PathVariable Long id, @RequestBody Permisos p) {
        Permisos permisos = permisosService.findById(id);
        if (permisos != null) {
            try {

                permisos.setPermEstado(p.getPermEstado());
                permisos.setPermFechaFin(p.getPermFechaFin());
                permisos.setPermFechaInicio(p.getPermFechaInicio());
                permisos.setPermHorasFin(p.getPermHorasFin());
                permisos.setPermHorasInicio(p.getPermHorasInicio());
                permisos.setPermObservacion(p.getPermObservacion());
                permisos.setTiPeId(p.getTiPeId());
                permisos.setMotId(p.getMotId());
                permisos.setTiFoId(p.getTiFoId());

                return new ResponseEntity<>(permisosService.save(permisos), HttpStatus.CREATED);
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
