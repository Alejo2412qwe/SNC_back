package com.senescyt.app.contoller;

import com.senescyt.app.model.Ciudad;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Ciudad")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/read")
    public ResponseEntity<List<Ciudad>> read() {
        return new ResponseEntity<>(ciudadService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Ciudad> create(@RequestBody Ciudad p) {
        return new ResponseEntity<>(ciudadService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id, @RequestBody Ciudad p) {
        Ciudad Ciudad = ciudadService.findById(id);
        if (Ciudad != null) {
            try {

                Ciudad.setCiuNombre(p.getCiuNombre());

                return new ResponseEntity<>(ciudadService.save(Ciudad), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        ciudadService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
