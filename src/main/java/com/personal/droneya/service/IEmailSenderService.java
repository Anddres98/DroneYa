package com.personal.droneya.service;

public interface IEmailSenderService {

    public void sendEmailWhitAttachment(String toEmail,
                                   String body,
                                   String subject,
                                   String attachment);

    public void sendEmail(String toEmail,
                          String body,
                          String subject,
                          String attachment);
}
