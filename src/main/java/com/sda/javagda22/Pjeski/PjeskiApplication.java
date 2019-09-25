package com.sda.javagda22.Pjeski;

import com.sda.javagda22.Pjeski.controller.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.io.File;

@SpringBootApplication
@EnableJms
public class PjeskiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjeskiApplication.class, args);
	}

}
