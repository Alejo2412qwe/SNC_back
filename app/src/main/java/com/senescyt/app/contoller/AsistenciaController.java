package com.senescyt.app.contoller;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.model.Rol;
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
    private AsistenciaService asistenciaService;

    @GetMapping("/read")
    public ResponseEntity<List<Asistencia>> read() {
        return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Asistencia> create(@RequestBody Asistencia p) {
        return new ResponseEntity<>(asistenciaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody Asistencia p) {
        Asistencia Asistencia = asistenciaService.findById(id);
        if (Asistencia != null) {
            try {

                Asistencia.setAsisNombre(p.getAsisNombre());
                Asistencia.setAsisFecha(p.getAsisFecha());
                Asistencia.setAsisVerificacion(p.getAsisVerificacion());
                Asistencia.setAsisEstado(p.isAsisEstado());
                Asistencia.setAsisHoraMarcado(p.getAsisHoraMarcado());
                Asistencia.setAsisLector(p.getAsisLector());

                return new ResponseEntity<>(asistenciaService.save(Asistencia), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        asistenciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
