package com.personal.droneya.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmeilSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("pronto.codee@gmail.com");
        message.setTo(toEmail);
        message.setTo(body);
        message.setTo(subject);

        mailSender.send(message);
        System.out.println("Mail send...");
    }

    public void sendEmailWhitAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("pronto.codee@gmail.com");
        //El toEmil es para cual correo se va enviar
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem =
                new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);


        mailSender.send(mimeMessage);
        System.out.println("mail send whit attachment");

    }

}

