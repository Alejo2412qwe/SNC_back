package com.senescyt.app.contoller;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    public AsistenciaService asistenciaService;

    @GetMapping("/read")
    public ResponseEntity<List<Asistencia>> read() {
        return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Asistencia> create(@RequestBody Asistencia a) {
        return new ResponseEntity<>(asistenciaService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody Asistencia a) {
        Asistencia asistencia = asistenciaService.findById(id);
        if (asistencia != null) {
            try {

                asistencia.setUsuIdHuella(a.getUsuIdHuella());
                asistencia.setAsiRol(a.getAsiRol());
                asistencia.setAsiFecha(a.getAsiFecha());
                asistencia.setAsiUsuario(a.getAsiUsuario());
                asistencia.setAsiTipoAsistencia(a.getAsiTipoAsistencia());

                return new ResponseEntity<>(asistenciaService.save(asistencia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Asistencia> delete(@PathVariable Long id) {
        asistenciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
