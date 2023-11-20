package com.senescyt.app.contoller;

import com.senescyt.app.model.Vacaciones;
import com.senescyt.app.model.Rol;
import com.senescyt.app.model.ValorHora;
import com.senescyt.app.service.VacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/vacaciones")
public class VacacionesController {
    @Autowired
    private VacacionesService vacacioneService;

    @GetMapping("/read")
    public ResponseEntity<List<Vacaciones>> read() {
        return new ResponseEntity<>(vacacioneService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/getVacacionesByEstado")
    public ResponseEntity<List<Vacaciones>> getVacacionesByEstado(@RequestParam int est) {
        return new ResponseEntity<>(vacacioneService.getVacacionesByEst(est), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vacaciones> create(@RequestBody Vacaciones p) {
        p.setVacEstado(1);
        // Realizar el cálculo y asignarlo a vacTotalenDias
        double horasEnDias = p.getVacHoras() / 8.0; // Dividir horas por 8 para obtener días
        double minutosEnDias = p.getVacMinutos() / 480.0; // Dividir minutos por 480 para obtener días
        double totalDias = horasEnDias + minutosEnDias + p.getVacDias();
        p.setVacTotalenDias(totalDias);

        // Realizar el cálculo para vacSaldo
        double nuevoSaldo = (p.getVacSaldo() + p.getVacDiasGanados()) - p.getVacTotalenDias();
        p.setVacSaldo(nuevoSaldo);

        // Establecer vacDiasUsados con el mismo valor que vacTotalenDias
        if (p.getVacTotalenDias() >= 0) {
            p.setVacDiasUsados(p.getVacTotalenDias());
        } else {
            p.setVacDiasUsados(p.getVacTotalenDias() * (-1));
        }
        return new ResponseEntity<>(vacacioneService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/updatetabla/{id}")
    public ResponseEntity<Vacaciones> updateTab(@PathVariable Long id, @RequestBody Vacaciones p) {
        Vacaciones Vacaciones = vacacioneService.findById(id);
        if (Vacaciones != null) {
            try {

                Vacaciones.setVacDetalle(p.getVacDetalle());
                Vacaciones.setVacDias(p.getVacDias());
                Vacaciones.setVacHoras(p.getVacHoras());
                Vacaciones.setVacMinutos(p.getVacMinutos());
                Vacaciones.setVacDiasGanados(p.getVacDiasGanados());
                Vacaciones.setVacNoGozadas(p.getVacNoGozadas());

                return new ResponseEntity<>(vacacioneService.save(Vacaciones), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEst")
    public ResponseEntity<Vacaciones> updateEst(@RequestParam Long id, @RequestParam int est) {
        Vacaciones vacaciones = vacacioneService.findById(id);
        if (vacaciones != null) {
            try {

                vacaciones.setVacEstado(est);
                vacacioneService.save(vacaciones);
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
        vacacioneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
