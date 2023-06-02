package com.personal.droneya.service;

import jakarta.mail.MessagingException;

public interface IEmailSenderService {

    public void sendEmailWhitAttachment(String toEmail,
                                   String body,
                                   String subject,
                                   String attachment) throws MessagingException;

    public void sendEmail(String toEmail,
                          String body,
                          String subject,
                          String attachment);
}
