package com.senescyt.app.contoller;


import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Comision;
import com.senescyt.app.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/comision")
public class ComisionController {

    @Autowired
    private ComisionService comisionService;

    @GetMapping("/read")
    public ResponseEntity<List<Comision>> read() {
        return new ResponseEntity<>(comisionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Comision> create(@RequestBody Comision p) {
        p.setComEstado(1);
        return new ResponseEntity<>(comisionService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comision> update(@PathVariable Long id, @RequestBody Comision p) {
        Comision Comision = comisionService.findById(id);
        if (Comision != null) {
            try {

                Comision.setComDetalle(p.getComDetalle());
                Comision.setComDesdeFecha(p.getComDesdeFecha());
                Comision.setComHastaFecha(p.getComHastaFecha());
                Comision.setComDias(p.getComDias());
                Comision.setComLugar(p.getComLugar());
                Comision.setComInforme(p.getComInforme());

                return new ResponseEntity<>(comisionService.save(Comision), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEst")
    public ResponseEntity<Comision> updateEst(@RequestParam Long id, @RequestParam int est) {
        Comision comision = comisionService.findById(id);
        if (comision != null) {
            try {

                comision.setComEstado(est);
                comisionService.save(comision);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        comisionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
