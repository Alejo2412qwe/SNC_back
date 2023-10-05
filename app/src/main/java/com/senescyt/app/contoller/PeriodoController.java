package com.senescyt.app.contoller;

import com.senescyt.app.model.Periodo;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/periodo")
public class PeriodoController {
    @Autowired
    private PeriodoService periodoService;

    @GetMapping("/read")
    public ResponseEntity<List<Periodo>> read() {
        return new ResponseEntity<>(periodoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Periodo> create(@RequestBody Periodo p) {
        return new ResponseEntity<>(periodoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Periodo> update(@PathVariable Long id, @RequestBody Periodo p) {
        Periodo Periodo = periodoService.findById(id);
        if (Periodo != null) {
            try {

                Periodo.setPeriActual(p.getPeriActual());
                Periodo.setPeriAnterior(p.getPeriAnterior());

                return new ResponseEntity<>(periodoService.save(Periodo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        periodoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
