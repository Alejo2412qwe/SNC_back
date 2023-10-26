package com.senescyt.app.contoller;

import com.senescyt.app.model.Horarios;
import com.senescyt.app.model.Institucion;
import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/institucion")
public class InstitucionController {


    @Autowired
    private InstitucionService institucionService;

    @GetMapping("/read")
    public ResponseEntity<List<Institucion>> read() {
        return new ResponseEntity<>(  institucionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/getInstitucionByTipId/{id}")
    public ResponseEntity<List<Institucion>> getInstitucionByTipId(@PathVariable Long id) {
        return new ResponseEntity<>(institucionService.getInstitucionByTipId(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Institucion> create(@RequestBody Institucion p) {
        return new ResponseEntity<>(  institucionService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Institucion> update(@PathVariable Long id, @RequestBody Institucion p) {
        Institucion institucion =   institucionService.findById(id);
        if (institucion != null) {
            try {

                institucion.setInstNombre(p.getInstNombre());
                institucion.setInstDireccion(p.getInstDireccion());
                institucion.setTipId(p.getTipId());


                return new ResponseEntity<>(  institucionService.save(institucion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Institucion> delete(@PathVariable Long id) {
          institucionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
