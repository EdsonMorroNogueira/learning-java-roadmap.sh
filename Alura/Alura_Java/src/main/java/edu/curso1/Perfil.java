package edu.curso1;

import java.util.Scanner;

public class Perfil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome);
    }
}
