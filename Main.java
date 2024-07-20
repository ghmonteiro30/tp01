public class Main {
    public static void main(String[] args) {
        // Cria uma distribuição exponencial com lambda = 1.0
        DistribuicaoExponencial dist = new DistribuicaoExponencial(1.0);

        // Gera 1000 valores a partir da distribuição exponencial
        double[] valores = dist.gerarValores(1000);

        // Calcula a média dos valores gerados
        double media = dist.calcularMedia(valores);
        System.out.println("Média: " + media);

        // Calcula a variância dos valores gerados
        double variancia = dist.calcularVariancia(valores);
        System.out.println("Variância: " + variancia);

        // Calcula o desvio padrão dos valores gerados
        double desvioPadrao = dist.calcularDesvioPadrao(valores);
        System.out.println("Desvio Padrão: " + desvioPadrao);
    }
}
