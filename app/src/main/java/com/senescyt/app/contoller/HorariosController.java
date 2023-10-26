package com.senescyt.app.contoller;

import com.senescyt.app.model.Horarios;
import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/horarios")
public class HorariosController {
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
    

    @GetMapping("/searchByHour/{hora}")
    public ResponseEntity<List<Horarios>> searchByHour(@PathVariable String hora) {
        List<Horarios> horarios = horariosService.findByHora(hora);
        if (horarios.isEmpty()) {
            // Si no se encuentran horarios con la hora especificada, devuelve un HttpStatus.NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(horarios, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Horarios> delete(@PathVariable Long id) {
        horariosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
