package Generic;

import Abstract.Distribuicao;

public class Estatisticas<T extends Distribuicao> {
    private T distribuicao;
    private double[] valoresGerados;

    public Estatisticas(T distribuicao) {
        this.distribuicao = distribuicao;
    }

    public void imprimirValoresGerados(int tamanho) {
        valoresGerados = distribuicao.gerarValores(tamanho);
        for (int i = 0; i < valoresGerados.length; i++) {
            System.out.print(valoresGerados[i]);
            if (i < valoresGerados.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void imprimirMedia() {
        System.out.println("Média: " + distribuicao.calcularMedia(valoresGerados));
    }

    public void imprimirVariancia() {
        System.out.println("Variância: " + distribuicao.calcularVariancia(valoresGerados));
    }

    public void imprimirDesvioPadrao() {
        System.out.println("Desvio Padrão: " + distribuicao.calcularDesvioPadrao(valoresGerados));
    }
}
