package br.com.respostas;

import java.util.Scanner;

public class Fibonacci {

    public static boolean pertenceFibonacci(int numero) {
        if (numero < 0) {
            return false;
        }

        int a = 0, b = 1;

        while (a < numero) {
            int temp = a;
            a = b;
            b = temp + b;
        }

        return a == numero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
            int numero = scanner.nextInt();

            if (pertenceFibonacci(numero)) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
            }
        } catch (Exception e) {
            System.out.println("Por favor, insira um número inteiro válido.");
        } finally {
            scanner.close();
        }
    }
}
