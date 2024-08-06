package com.morro.desafio_fipe;

import com.morro.desafio_fipe.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFipeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Main main = new Main();
		main.exibirMenu();
	}
}
