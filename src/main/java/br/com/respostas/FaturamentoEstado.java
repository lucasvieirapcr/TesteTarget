package br.com.respostas;

import java.util.HashMap;
import java.util.Map;

public class FaturamentoEstado {

    public static void main(String[] args) {
        Map<String, Double> faturamento = new HashMap<>();
        faturamento.put("SP", 67836.43);
        faturamento.put("RJ", 36678.66);
        faturamento.put("MG", 29229.88);
        faturamento.put("ES", 27165.48);
        faturamento.put("Outros", 19849.53);

        double totalFaturamento = faturamento.values().stream().mapToDouble(Double::doubleValue).sum();

        Map<String, Double> percentuais = new HashMap<>();
        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            double percentual = (entry.getValue() / totalFaturamento) * 100;
            percentuais.put(entry.getKey(), percentual);
        }

        System.out.printf("Total de faturamento mensal: R$%.2f%n", totalFaturamento);
        System.out.println("Percentual de representação de cada estado:");
        for (Map.Entry<String, Double> entry : percentuais.entrySet()) {
            System.out.printf("%s: %.2f%%%n", entry.getKey(), entry.getValue());
        }
    }
}
