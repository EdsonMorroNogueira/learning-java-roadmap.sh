//package com.morro.edson.screenmatch_curso2;
//
//import com.morro.edson.screenmatch_curso2.main.Main;
//import com.morro.edson.screenmatch_curso2.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenmatchApplicationSemWeb implements CommandLineRunner {
//
//    @Autowired
//    private SerieRepository serieRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(ScreenmatchApplicationSemWeb.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Main main = new Main(serieRepository);
//        main.exibirMenu();
//    }
//}
