import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class DistribuicaoNormal{
    private double media;
    private double dp;
    private List<Double> valores;

    public DistribuicaoNormal(double media, double desvioPadrao) {
        this.media = media;
        this.dp = desvioPadrao;
    }

    @Override
    public List<Double> gerarValores(int tamanhoAmostra) {
        valores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < tamanhoAmostra; i++) {
            valores.add(media + dp * random.nextGaussian());
        }
        return valores;
    }

    @Override
    public double calcularMedia() {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return valores.isEmpty() ? 0 : soma / valores.size();
    }

    @Override
    public double calcularVariancia() {
        double media = calcularMedia();
        double soma = 0;
        for (double valor : valores) {
            soma += Math.pow(valor - media, 2);
        }
        return valores.isEmpty() ? 0 : soma / (valores.size() - 1);
    }

    @Override
    public double calcularDesvioPadrao() {
        return Math.sqrt(calcularVariancia());
    }
}