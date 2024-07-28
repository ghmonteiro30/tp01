import Abstract.Distribuicao;

import java.util.Random;

public class DistribuicaoPoisson extends Distribuicao {
    private double lambda;
    private Random random;

    public DistribuicaoPoisson(double lambda) {
        this.lambda = lambda;
        this.random = new Random();
    }

    @Override
    public double[] gerarValores(int n) {
        double[] valores = new double[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            double produto = 1.0;
            double limite = Math.exp(-lambda);
            //laço que vai até que produto seja <= limite
            do {
                count++;
                produto *= random.nextDouble();
            } while (produto > limite);
            valores[i] = count - 1;
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
