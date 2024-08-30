//package com.morro.edson.screenmatch_curso2.desafio.main;
//
//import java.util.Scanner;
//
//public class Main {
//
//    private Scanner leitura = new Scanner(System.in);
//
//    private ArtistaRepository repository;
//
//    public Main() {}
//
//    public Main(ArtistaRepository repository) {
//        this.repository = repository;
//    }
//
//    public void exibirMenu() {
//        var opcao = -1;
//        while (opcao != 0) {
//            var menu = """
//
//                        1- Cadastrar artistas
//
//                        2- Cadastrar músicas
//
//                        3- Listar músicas
//
//                        4- Buscar músicas por artistas
//
//                        5- Pesquisar dados sobre um artista
//
//                        0- Sair
//
//                    """;
//
//            System.out.println(menu);
//            opcao = leitura.nextInt();
//            leitura.nextLine();
//
//            switch (opcao) {
//                case 1:
//                    // POST ARTISTAS
//                    break;
//                case 2:
//                    // POST MUSICAS
//                    break;
//                case 3:
//                    // GET MUSICAS
//                    break;
//                case 4:
//                    //GET MUSICAS FILTER ARTISTA
//                    break;
//                case 5:
//                    //GET ARTISTA FILTER NOME ARTISTA
//                    break;
//                case 0:
//                    System.out.println("Saindo...");
//                    break;
//                default:
//                    System.out.println("Opção inválida");
//            }
//        }
//
//    }
//}
