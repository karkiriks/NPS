package com.nxtc.nps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.nxtc.*"})
public class NpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpsApplication.class, args);
	}

}
