package com.personal.droneya;

import com.personal.droneya.service.impl.EmeilSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DroneyaApplication {


	public static void main(String[] args) {
		SpringApplication.run(DroneyaApplication.class, args);
	}


}


