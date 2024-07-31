package edu.edson.nivelamento.media;

import java.util.Scanner;

public class CalculadoraMedia {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno:");
        String nomeUser = scanner.nextLine();

        System.out.println("Digite a 1ª nota:");
        double nota1 = scanner.nextDouble();

        System.out.println("Digite a 2ª nota:");
        double nota2 = scanner.nextDouble();

        double media = calcularMedia(nota1, nota2);

        System.out.println("Olá, " + nomeUser + ". Sua média foi de " + media);
    }

    public static double calcularMedia(double nota1, double nota2) {

        return (nota1 + nota2) / 2;
    }

}

