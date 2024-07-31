package edu.edson.nivelamento.calorias;

import java.util.Scanner;

public class CalculadoraCalorias {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Seu nome?");
        String nome = scanner.nextLine();
        System.out.println("Quantos minutos de Aquecimento?");
        int aquecimento = scanner.nextInt();
        System.out.println("Quantos minutos de Aeróbico?");
        int aerobico = scanner.nextInt();
        System.out.println("Quantos minutos de Musculação?");
        int musculacao = scanner.nextInt();
        int totalMinutos = aquecimento + aerobico + musculacao;

        int caloriaAquecimento = aquecimento * 12;
        int caloriaAerobico = aerobico * 20;
        int caloriaMusculacao = musculacao * 25;

        int totalCalorias = caloriaMusculacao + caloriaAerobico + caloriaAquecimento;


        System.out.println("Olá"+ nome + ". Você fez um total de "+ totalMinutos + " minutos de exercícios e perdeu cerca de "+ totalCalorias+" calorias.");
    }

    }
