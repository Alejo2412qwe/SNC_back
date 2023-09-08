package com.senescyt.app.contoller;

import com.senescyt.app.contoller.dto.EmailValues;
import com.senescyt.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class emailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public ResponseEntity<?> sendEmail() {
        emailService.sendEmail();
        return new ResponseEntity<>("Correo enviado con exito", HttpStatus.OK);
    }

    @PostMapping("/sendHtml")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValues valores) {
        emailService.sendEmailTemplate(valores);
        return new ResponseEntity<>("Correo con plantilla enviado con exito", HttpStatus.OK);
    }
}
