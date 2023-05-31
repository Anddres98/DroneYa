package com.personal.droneya;

import com.personal.droneya.service.impl.EmeilSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DroneyaApplication {

	@Autowired
	private EmeilSenderService service;
	public static void main(String[] args) {
		SpringApplication.run(DroneyaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){
		service.sendSimpleEmail("Aquien se va enviar",
				"contenido del mail",
				"el asunto del mail");

		service	.sendEmailWhitAttachment("emeil donde va llegar",
				"this is Email body whit attachment",
				"this email has attachment",
				"Aqui ira el adjunto que desea enviar");
	}

}
