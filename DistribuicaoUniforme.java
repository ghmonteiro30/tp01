import Abstract.Distribuicao;

import java.util.Random;

public class DistribuicaoUniforme extends Distribuicao {
    private double limiteInferior;
    private double limiteSuperior;
    private Random random;

    public DistribuicaoUniforme(double limiteInferior, double limiteSuperiror) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperiror;
        this.random = new Random();
    }

    @Override
    public double[] gerarValores(int n) {
        double[] valores = new double[n];
        for (int i = 0; i < n; i++) {
            valores[i] = limiteInferior + (limiteSuperior - limiteInferior) * random.nextDouble();
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
