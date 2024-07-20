import java.util.Random;

abstract class Distribuicao {
    public abstract double[] gerarValores(int tamanho);
    public abstract double calcularMedia(double[] valores);
    public abstract double calcularVariancia(double[] valores);
    public abstract double calcularDesvioPadrao(double[] valores);
}

public class DistribuicaoExponencial extends Distribuicao {
    private double lambda;
    private Random random;

    public DistribuicaoExponencial(double lambda) {
        this.lambda = lambda;
        this.random = new Random();
    }

    @Override
    public double[] gerarValores(int tamanho) {
        double[] valores = new double[tamanho];
        for (int i = 0; i < tamanho; i++) {
            valores[i] = Math.log(1 - random.nextDouble()) / (-lambda);
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
