package br.com.respostas.faturamentoJSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FaturamentoJSON {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File("C:\\Users\\20221461\\Desktop\\DesafioTarget\\Respostas\\src\\main\\java\\br\\com\\respostas\\faturamentoJSON\\faturamento.json");
            List<JsonNode> dados = objectMapper.readValue(file, new TypeReference<List<JsonNode>>(){});

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;
            int diasAcimaMedia = 0;

            for (JsonNode dia : dados) {
                double valor = dia.get("valor").asDouble();

                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }

                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = diasComFaturamento > 0 ? somaFaturamento / diasComFaturamento : 0;

            for (JsonNode dia : dados) {
                double valor = dia.get("valor").asDouble();

                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            // Exibe os resultados
            System.out.printf("Menor valor de faturamento ocorrido em um dia do mês: %.2f%n", menorValor);
            System.out.printf("Maior valor de faturamento ocorrido em um dia do mês: %.2f%n", maiorValor);
            System.out.printf("Número de dias no mês em que o valor de faturamento foi superior à média mensal: %d%n", diasAcimaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
