package com.senescyt.app.emailRecover.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senescyt.app.emailRecover.dto.CambiarContra;
import com.senescyt.app.emailRecover.dto.EmailValues;
import com.senescyt.app.emailRecover.message.Message;
import com.senescyt.app.emailRecover.service.EmailServiceImpl;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class emailController {

    @Autowired
    EmailServiceImpl emailService;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private UsuarioService usuarioService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/sendRecuperacionPassword/{email}")
    public ResponseEntity<?> sendEmailRecuperacion(@PathVariable("email") String email){

        try {
            Usuario usuario = usuarioService.findByPersonaCorreo(email);
            if (usuario == null) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Message.ERROR_404);
            }
            EmailValues values = new EmailValues();
            values.setEmailFrom(emailFrom);
            values.setEmailTo(usuario.getUsuPerId().getPerCorreo());
            values.setUserName(usuario.getUsuPerId().getPerNombre() + ' ' + usuario.getUsuPerId().getPerApellido());
            values.setSubject("RESTAURAR CONSTRASEÑA");
            UUID uuid = UUID.randomUUID();
            String tokenPassword  = uuid.toString();
            values.setToken(tokenPassword);
            usuario.setUsuTokenPassword(tokenPassword);

            if(emailService.sendEmail(values) == true) {
                usuarioService.save(usuario);
                String responseBody = objectMapper.writeValueAsString(Message.SUCCESSFUL_200);
                return ResponseEntity.status(HttpStatus.OK).body(responseBody);
            }else {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.ERROR_400);
            }

        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Message.ERROR_500);
        }

    }

    @PostMapping("/cambiarContraseniaUsuario")
    public ResponseEntity<?> cambiarContraseniaUsuario(@Valid @RequestBody CambiarContra dto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Campos mal puestos", HttpStatus.BAD_REQUEST);
            }
            if (!dto.getPassword().equals(dto.getPasswordr())) {
                return new ResponseEntity<>("No coinciden", HttpStatus.BAD_REQUEST);
            }
            Usuario usuario = usuarioService.findByUsuTokenPassword(dto.getToken());
            if (usuario == null) {
                return new ResponseEntity<>("No encontrado el usuario", HttpStatus.NOT_FOUND);
            }

            usuario.setUsuContrasena(dto.getPassword());
            usuario.setUsuTokenPassword(null);
            usuarioService.save(usuario);
            return new ResponseEntity<>(objectMapper.writeValueAsString("SUCCESSFUL"), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
