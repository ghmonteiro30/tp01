import Abstract.Distribuicao;

import java.util.Random;

public class DistribuicaoNormal extends Distribuicao {
    private double media;
    private double dp;

    public DistribuicaoNormal(double media, double desvioPadrao) {
        this.media = media;
        this.dp = desvioPadrao;
    }

    @Override
    public double[] gerarValores(int tamanhoAmostra) {
        double[] valores = new double[tamanhoAmostra];
        Random random = new Random();
        for (int i = 0; i < tamanhoAmostra; i++) {
            valores[i] =(media + dp * random.nextGaussian());
        }
        return valores;
    }

    @Override
    public double calcularMedia(double[] valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    @Override
    public double calcularVariancia(double[] valores) {
        double media = calcularMedia(valores);
        double soma = 0;
        for (double valor : valores) {
            soma += Math.pow(valor - media, 2);
        }
        return soma / (valores.length - 1);
    }

    @Override
    public double calcularDesvioPadrao(double[] valores) {
        return Math.sqrt(calcularVariancia(valores));
    }
}