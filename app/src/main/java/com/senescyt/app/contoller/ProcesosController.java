package com.senescyt.app.contoller;

import com.senescyt.app.model.Procesos;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.ProcesosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/procesos")
public class ProcesosController {
    @Autowired
    private ProcesosService procesosService;

    @GetMapping("/read")
    public ResponseEntity<List<Procesos>> read() {
        return new ResponseEntity<>(procesosService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Procesos> create(@RequestBody Procesos p) {
        return new ResponseEntity<>(procesosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Procesos> update(@PathVariable Long id, @RequestBody Procesos p) {
        Procesos Procesos = procesosService.findById(id);
        if (Procesos != null) {
            try {

                Procesos.setProcNombre(p.getProcNombre());
                return new ResponseEntity<>(procesosService.save(Procesos), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        procesosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
