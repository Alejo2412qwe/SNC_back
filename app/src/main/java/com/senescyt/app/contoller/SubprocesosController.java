package com.senescyt.app.contoller;

import com.senescyt.app.model.Subprocesos;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.SubprocesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/subprocesos")
public class SubprocesosController {
    @Autowired
    private SubprocesoService subprocesosService;

    @GetMapping("/read")
    public ResponseEntity<List<Subprocesos>> read() {
        return new ResponseEntity<>(subprocesosService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/getSubprocesos/{id}")
    public ResponseEntity<Subprocesos> getSubprocesosByProcesosId(@PathVariable Long id) {
        return new ResponseEntity<>(subprocesosService.getSubprocesosByProcId(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Subprocesos> create(@RequestBody Subprocesos p) {
        return new ResponseEntity<>(subprocesosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Subprocesos> update(@PathVariable Long id, @RequestBody Subprocesos p) {
        Subprocesos Subprocesos = subprocesosService.findById(id);
        if (Subprocesos != null) {
            try {

                Subprocesos.setSubNombre(p.getSubNombre());

                return new ResponseEntity<>(subprocesosService.save(Subprocesos), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        subprocesosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
