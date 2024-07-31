package edu.curso1;

public class Media {

    public static void main(String[] args) {

        double num1 = 9.5;
        double num2 = 6.0;

        double media = (num1 + num2) / 2;

        System.out.println(media);

       int num2Int = (int) num2;
       System.out.println(num2Int);

       char letraA ='A';
       String palavra = "Ayoba";
       System.out.println(letraA + palavra);

       double precoProduto = 39.99;
       int quantidade = 40;
       double total = precoProduto * quantidade;
        System.out.printf("Se a quantidade %d for vendida por %.2f\nTeremos a receita de %.2f", quantidade, precoProduto, total);

        double valorEmDolares = 60.0;
        double dolarConvertidoReal = valorEmDolares * 5.65;
        System.out.printf("\nO valor $%.2f em reais é de %.2f", valorEmDolares, dolarConvertidoReal);

        double precoOriginal = 19.99;
        double percentualDesconto = 0.1;
        double desconto = precoOriginal * percentualDesconto;

        System.out.printf("\nO desconto de 10 porcento sobre o preço %.2f é de %.2f", precoOriginal, desconto);

    }
}
