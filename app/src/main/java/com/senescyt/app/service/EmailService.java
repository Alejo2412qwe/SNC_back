package com.senescyt.app.service;

import com.senescyt.app.contoller.dto.EmailValues;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;


//servicio para el envio del correo de recuperacion de contrasena
//video: https://www.youtube.com/watch?v=jd0OUoXPcS8&t=133s&ab_channel=LuigiCode
@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();


        javaMailSender.send(message);

    }

    public void sendEmailTemplate(EmailValues valores) {

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", valores.getUserName());
            model.put("url",urlFront+valores.getToken());
            context.setVariables(model);
            String htmlText = templateEngine.process("email-template", context);
            helper.setFrom(valores.getEmailFrom());
            helper.setTo(valores.getEmailTo());
            helper.setSubject(valores.getSubject());
            helper.setText(htmlText, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
