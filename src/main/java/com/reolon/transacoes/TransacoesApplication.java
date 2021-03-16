package com.reolon.transacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TransacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacoesApplication.class, args);
	}

}
