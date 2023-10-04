package com.senescyt.app.contoller;

import com.senescyt.app.model.Horarios;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/institucion")
public class InstitucionController {
    @Autowired
    private HorariosService horariosService;

    @GetMapping("/read")
    public ResponseEntity<List<Horarios>> read() {
        return new ResponseEntity<>(horariosService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Horarios> create(@RequestBody Horarios p) {
        return new ResponseEntity<>(horariosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Horarios> update(@PathVariable Long id, @RequestBody Horarios p) {
        Horarios Horarios = horariosService.findById(id);
        if (Horarios != null) {
            try {

                Horarios.setHorHoraIngreso(p.getHorHoraIngreso());
                Horarios.setHorHoraSalida(p.getHorHoraSalida());
                Horarios.setHorHoraAlmuerzoInicio(p.getHorHoraAlmuerzoInicio());
                Horarios.setHorHoraAlmuerzoFin(p.getHorHoraAlmuerzoFin());
                Horarios.setHorNumHoras(p.getHorNumHoras());

                return new ResponseEntity<>(horariosService.save(Horarios), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        horariosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
