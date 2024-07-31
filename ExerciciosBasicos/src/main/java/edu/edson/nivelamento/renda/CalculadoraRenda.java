package edu.edson.nivelamento.renda;

import java.util.Scanner;

public class CalculadoraRenda {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos filhos de 0 a 3 anos você tem?");
        int filhos0A3 = scanner.nextInt();
        System.out.println("Quantos filhos de 4 a 16 anos você tem?");
         int filhos4A16 = scanner.nextInt();
        System.out.println("Quantos filhos de 17 a 18 anos você tem?");
         int filhos17A18 = scanner.nextInt();

         int totalFilhos = filhos0A3 + filhos4A16 + filhos17A18;

         double bolsa1 = filhos0A3 * 25.12;
         double bolsa2 = filhos4A16 * 15.88;
         double bolsa3 = filhos17A18 * 12.44;

         double totalBolsa = bolsa1 + bolsa2 + bolsa3;

        System.out.printf("Você tem um total de "+ totalFilhos + " e vai receber R$" + totalBolsa + " de bolsa");

    }


}
