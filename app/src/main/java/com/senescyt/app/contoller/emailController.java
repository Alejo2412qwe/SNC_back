package com.senescyt.app.contoller;

import com.senescyt.app.contoller.dto.EmailValues;
import com.senescyt.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class emailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValues values) {
        emailService.sendEmail(values);
        return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
    }
}
