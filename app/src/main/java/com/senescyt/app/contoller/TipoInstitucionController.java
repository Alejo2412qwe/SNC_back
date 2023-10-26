package com.senescyt.app.contoller;

import com.senescyt.app.model.TipoInstitucion;
import com.senescyt.app.model.TipoPermiso;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.TipoInstitucionService;
import com.senescyt.app.service.TipoPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tipoinstitucion")
public class TipoInstitucionController {

    @Autowired
    private TipoInstitucionService tipoInstitucionService;

    @GetMapping("/read")
    public ResponseEntity<List<TipoInstitucion>> read() {
        return new ResponseEntity<>(tipoInstitucionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TipoInstitucion> create(@RequestBody TipoInstitucion ti) {
        return new ResponseEntity<>(tipoInstitucionService.save(ti), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoInstitucion> update(@PathVariable Long id, @RequestBody TipoInstitucion ti) {
        TipoInstitucion tipoInstitucion = tipoInstitucionService.findById(id);
        if (tipoInstitucion != null) {
            try {

                tipoInstitucion.setTipNombre(ti.getTipNombre());

                return new ResponseEntity<>(tipoInstitucionService.save(tipoInstitucion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TipoInstitucion> delete(@PathVariable Long id) {
        tipoInstitucionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
