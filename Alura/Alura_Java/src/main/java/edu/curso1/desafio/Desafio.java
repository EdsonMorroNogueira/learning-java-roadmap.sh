package edu.curso1.desafio;

import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {

        String nomeCliente = "Flávia Nakama";
        String tipoConta = "Corrente";
        double saldo = 1500.0;
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.printf("***********************");
        System.out.printf("\nNome do Cliente: %s", nomeCliente);
        System.out.printf("\nTipo Conta: %s", tipoConta);
        System.out.printf("\nSaldo atual: %.2f", saldo);
        System.out.println("\n***********************");

        String menu = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair

                """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Seu saldo atual é " + saldo);
            } else if (opcao == 2) {
                System.out.println("Quanto você quer transferir?");
                double numTransfer = scanner.nextDouble();

                if (numTransfer > saldo){
                    System.out.println("Você não pode transferir essa quantia porque ela é maior que seu saldo atual");
                } else {
                    saldo -= numTransfer;
                    System.out.println("Novo saldo: " + saldo);
                }
            } else if (opcao == 3){
                System.out.println("Quanto você deseja depositar?");
                double numAdd = scanner.nextDouble();
                saldo += numAdd;
                System.out.println("Novo saldo: " + saldo);
            } else if (opcao != 4){
                System.out.println("Opção inválida!");
            }
        }
    }
}
