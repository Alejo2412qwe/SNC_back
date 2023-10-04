package com.senescyt.app.contoller;

import com.senescyt.app.model.TipoFormulario;
import com.senescyt.app.model.Rol;
import com.senescyt.app.service.TipoFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoformulario")
public class TipoFormularioController {
    @Autowired
    private TipoFormularioService tipFormularioService;

    @GetMapping("/read")
    public ResponseEntity<List<TipoFormulario>> read() {
        return new ResponseEntity<>(tipFormularioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TipoFormulario> create(@RequestBody TipoFormulario p) {
        return new ResponseEntity<>(tipFormularioService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoFormulario> update(@PathVariable Long id, @RequestBody TipoFormulario p) {
        TipoFormulario TipoFormulario = tipFormularioService.findById(id);
        if (TipoFormulario != null) {
            try {

                TipoFormulario.setTiFoNombre(p.getTiFoNombre());
                TipoFormulario.setTiFoDocumento(p.getTiFoDocumento());

                return new ResponseEntity<>(tipFormularioService.save(TipoFormulario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        tipFormularioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
