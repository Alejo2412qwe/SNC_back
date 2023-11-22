package com.senescyt.app.contoller;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.model.Persona;
import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.service.AsistenciaService;
import com.senescyt.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/read")
    public ResponseEntity<List<Asistencia>> read() {
        return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/historialArchivos")
    public ResponseEntity<List<Map<String, Object>>> historialArchivos() {
        List<Map<String, Object>> hist = new ArrayList<>();
        List<Object[]> objs = asistenciaService.historialArchivos();

        for (Object[] data : objs) {
            Map<String, Object> obj = new HashMap<>();

            obj.put("indice", data[0]);
            obj.put("nombreArchivo", data[1]);
            obj.put("fechaArchivo", data[2]);
            obj.put("cantidadRegistros", data[3]);
            Long usuId = (Long) data[4];
            Usuario user = usuarioService.findByUsuId(usuId);
//            user.setUsuContrasena("");
            obj.put("userId", user);

            hist.add(obj);
        }

        return new ResponseEntity<>(hist, HttpStatus.OK);
    }

    @GetMapping("/historialArchivosSearch")
    public ResponseEntity<List<Map<String, Object>>> historialArchivosSearch(@RequestParam String fechaMin, @RequestParam String fechaMax, @RequestParam String nombre) {
        List<Map<String, Object>> hist = new ArrayList<>();
        List<Object[]> objs = asistenciaService.historialArchivosSearch(fechaMin, fechaMax, nombre);

        for (Object[] data : objs) {
            Map<String, Object> obj = new HashMap<>();

            obj.put("indice", data[0]);
            obj.put("nombreArchivo", data[1]);
            obj.put("fechaArchivo", data[2]);
            obj.put("cantidadRegistros", data[3]);
            Long usuId = (Long) data[4];
            Usuario user = usuarioService.findByUsuId(usuId);
//            user.setUsuContrasena("");
            obj.put("userId", user);

            hist.add(obj);
        }

        return new ResponseEntity<>(hist, HttpStatus.OK);
    }

    @GetMapping("/asistenciaSearch")
    public ResponseEntity<List<Map<String, Object>>> asistenciaSearch(@RequestParam String fechaMin, @RequestParam String fechaMax, @RequestParam String search) {
        List<Map<String, Object>> hist = new ArrayList<>();
        List<Object[]> objs = asistenciaService.asistenciaSearch(fechaMin, fechaMax, search);

        for (Object[] data : objs) {
            Map<String, Object> obj = new HashMap<>();
            Long asisId = (Long) data[0];
            Asistencia asistencia = asistenciaService.findById(asisId);
            obj.put("asisId", asistencia);

            Long usuId = (Long) data[1];
            Usuario user = usuarioService.findByUsuId(usuId);
//            user.setUsuContrasena("");
            obj.put("userId", user);

            hist.add(obj);
        }

        return new ResponseEntity<>(hist, HttpStatus.OK);
    }

    @GetMapping("/miAsistencia")
    public ResponseEntity<List<Map<String, Object>>> miAsistencia(@RequestParam Long usuId, @RequestParam String fechaMin, @RequestParam String fechaMax) {
        List<Map<String, Object>> hist = new ArrayList<>();
        List<Object[]> objs = asistenciaService.miAsistencia(usuId, fechaMin, fechaMax);

        for (Object[] data : objs) {
            Map<String, Object> obj = new HashMap<>();
            Long asisId = (Long) data[0];
            Asistencia asistencia = asistenciaService.findById(asisId);
            obj.put("asisId", asistencia);

            Long userId = (Long) data[1];
            Usuario user = usuarioService.findByUsuId(userId);
//            user.setUsuContrasena("");
            obj.put("userId", user);

            hist.add(obj);
        }

        return new ResponseEntity<>(hist, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Asistencia> create(@RequestBody Asistencia p) {
        return new ResponseEntity<>(asistenciaService.save(p), HttpStatus.CREATED);
    }

    @PostMapping("/saveList")
    public ResponseEntity<List<Asistencia>> createList(@RequestBody List<Asistencia> asistencias) {

        return new ResponseEntity<>(asistenciaService.saveAll(asistencias), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Asistencia> update(@PathVariable Long id, @RequestBody Asistencia p) {
        Asistencia Asistencia = asistenciaService.findById(id);
        if (Asistencia != null) {
            try {

                Asistencia.setAsisNombre(p.getAsisNombre());
                Asistencia.setAsisDpto(p.getAsisDpto());
                Asistencia.setAsisNoLector(p.getAsisNoLector());
                Asistencia.setAsisFechaHora(p.getAsisFechaHora());
                Asistencia.setAsisEstado(p.getAsisEstado());
                Asistencia.setAsisLocacionId(p.getAsisLocacionId());
                Asistencia.setAsisIdNumero(p.getAsisIdNumero());
                Asistencia.setAsisCodTrabajo(p.getAsisCodTrabajo());
                Asistencia.setAsisVerificaCod(p.getAsisVerificaCod());
                Asistencia.setAsisNoTarjeta(p.getAsisNoTarjeta());

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
