package com.personal.droneya.controller;

import com.personal.droneya.service.impl.EmeilSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmeilSenderController {

    @Autowired
    private EmeilSenderService service;

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        /*System.out.println("entra");
        service.sendSimpleEmail("andress.pardo98@gmail.com",
                "contenido del mail",
                "el asunto del mail");*/

        service.sendEmailWhitAttachment("andress.pardo98@gmail.com",
                "<h1> Congrats </h1> /s",
                "Offert punch here and you should next winner the this offert",
                "C:\\Users\\Andres Pardo\\OneDrive\\Escritorio\\Cursos Programacion\\Proyecto Drone\\droneya\\droneya\\src\\main\\java\\com\\personal\\droneya\\controller\\image.png");
    }
}
