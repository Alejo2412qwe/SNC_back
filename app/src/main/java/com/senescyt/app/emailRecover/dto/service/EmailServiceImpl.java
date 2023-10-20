package com.senescyt.app.emailRecover.dto.service;

import com.senescyt.app.emailRecover.dto.EmailValues;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;


//servicio para el envio del correo de recuperacion de contrasena
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    private org.thymeleaf.ITemplateEngine ITemplateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;

    public boolean sendEmail(EmailValues values) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("username", values.getUserName());
            model.put("url", urlFront + values.getToken());
            context.setVariables(model);
            String htmlText = ITemplateEngine.process("email_template",context);
            helper.setFrom(values.getEmailFrom());
            helper.setTo(values.getEmailTo());
            helper.setSubject(values.getSubject());
            helper.setText(htmlText,true);
            javaMailSender.send(message);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
