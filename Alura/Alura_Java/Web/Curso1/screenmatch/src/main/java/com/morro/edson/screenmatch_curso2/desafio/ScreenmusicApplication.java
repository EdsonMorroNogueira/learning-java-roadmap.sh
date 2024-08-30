//package com.morro.edson.screenmatch_curso2.desafio;
//
//import com.morro.edson.screenmatch_curso2.ScreenmatchApplication;
//import com.morro.edson.screenmatch_curso2.desafio.main.Main;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//
//public class ScreenmusicApplication implements CommandLineRunner {
//
//    @Autowired
//    private ArtistaRepository artistaRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(ScreenmatchApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Main main = new Main(artistaRepository);
//        main.exibirMenu();
//    }
//}
