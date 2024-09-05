package br.com.respostas;
import java.util.Scanner;

public class InvertendoCaracteres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a string para inverter:");
        String entrada = scanner.nextLine();

        scanner.close();

        String resultado = inverterString(entrada);

        System.out.println("String invertida: " + resultado);
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();

        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        return new String(caracteres);
    }
}
