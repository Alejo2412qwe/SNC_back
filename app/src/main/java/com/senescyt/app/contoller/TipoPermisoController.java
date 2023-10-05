package com.senescyt.app.contoller;

import com.senescyt.app.model.TipoPermiso;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.TipoPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tipopermiso")
public class TipoPermisoController {
    @Autowired
    private TipoPermisoService tipPermisoService;

    @GetMapping("/read")
    public ResponseEntity<List<TipoPermiso>> read() {
        return new ResponseEntity<>(tipPermisoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TipoPermiso> create(@RequestBody TipoPermiso p) {
        return new ResponseEntity<>(tipPermisoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoPermiso> update(@PathVariable Long id, @RequestBody TipoPermiso p) {
        TipoPermiso TipoPermiso = tipPermisoService.findById(id);
        if (TipoPermiso != null) {
            try {

                TipoPermiso.setTiPeNombre(p.getTiPeNombre());
                TipoPermiso.setTiPeEstado(p.isTiPeEstado());

                return new ResponseEntity<>(tipPermisoService.save(TipoPermiso), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        tipPermisoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
