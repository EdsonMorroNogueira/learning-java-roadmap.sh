package edu.curso3.desafio;

import edu.curso3.desafio.modelos.Cartao;
import edu.curso3.desafio.modelos.Produto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        List<Produto> carrinhoCompras = new LinkedList<>();

        System.out.println("Digite o limite do cartão:");
        Cartao cartao = new Cartao(scanner.nextInt());
        double totalCompra = 0;

        while (opcao != 0) {
            System.out.println("Digite a descrição da compra: ");
            String descProd = scanner.next();
            System.out.println("Digite o valor da compra: ");
            double precoProd = scanner.nextDouble();
            double predictTotal = 0;
            predictTotal += precoProd;

            if (cartao.getLimite() < precoProd || cartao.getLimite() < predictTotal){
                System.out.println("Saldo insuficiente!");
                if (!carrinhoCompras.isEmpty()) {
                    finalizarCompra(carrinhoCompras, totalCompra, cartao);

                } else {
                    System.out.println("Tente comprar algo que seja mais barato");
                }
                break;
            } else {
                Produto novoProduto = new Produto(descProd, precoProd);
                carrinhoCompras.add(novoProduto);
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                opcao = scanner.nextInt();
            }
        }

        if (opcao == 0) {
            finalizarCompra(carrinhoCompras, totalCompra, cartao);
        }
    }

    public static void finalizarCompra(List<Produto> carrinhoCompras, double totalCompra, Cartao cartao) {

        System.out.println("COMPRAS REALIZADAS:");
        Collections.sort(carrinhoCompras);

        for (Produto produto: carrinhoCompras) {
            System.out.println(produto.getNome() + " - " + produto.getPreco());
            totalCompra += produto.getPreco();
        }

        System.out.println("Saldo do cartão: " + (cartao.getLimite() - totalCompra));
    }
}


