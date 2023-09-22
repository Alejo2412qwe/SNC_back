package com.senescyt.app.contoller;

import com.senescyt.app.model.Vacaciones;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.VacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vacaciones")
public class VacacionesController {
    @Autowired
    private VacacionesService vacacioneService;

    @GetMapping("/read")
    public ResponseEntity<List<Vacaciones>> read() {
        return new ResponseEntity<>(vacacioneService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vacaciones> create(@RequestBody Vacaciones p) {
        return new ResponseEntity<>(vacacioneService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vacaciones> update(@PathVariable Long id, @RequestBody Vacaciones p) {
        Vacaciones Vacaciones = vacacioneService.findById(id);
        if (Vacaciones != null) {
            try {

                Vacaciones.setVacDetalle(p.getVacDetalle());
                Vacaciones.setVacFecha(p.getVacFecha());
                Vacaciones.setVacDiasCaducados(p.getVacDiasCaducados());
                Vacaciones.setVacDiasAnticipacion(p.getVacDiasAnticipacion());
                Vacaciones.setVacDiasGanados(p.getVacDiasGanados());
                Vacaciones.setVacDiasUsados(p.getVacDiasUsados());
                Vacaciones.setVacTotalDiasDisponibles(p.getVacTotalDiasDisponibles());
                Vacaciones.setVacSaldo(p.getVacSaldo());

                return new ResponseEntity<>(vacacioneService.save(Vacaciones), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        vacacioneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
