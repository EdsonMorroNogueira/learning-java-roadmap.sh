package com.morro.edson.screenmatch;

import com.morro.edson.screenmatch.model.DadosEpisodio;
import com.morro.edson.screenmatch.model.DadosSerie;
import com.morro.edson.screenmatch.model.DadosTemporada;
import com.morro.edson.screenmatch.principal.Main;
import com.morro.edson.screenmatch.service.ConsumoApi;
import com.morro.edson.screenmatch.service.implementation.ConverteDadosImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Main main = new Main();
		main.exibirMenu();
	}
}
