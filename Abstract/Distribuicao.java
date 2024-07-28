package Abstract;

public abstract class Distribuicao {
    public abstract double[] gerarValores(int tamanho);
    public abstract double calcularMedia(double[] valores);
    public abstract double calcularVariancia(double[] valores);
    public abstract double calcularDesvioPadrao(double[] valores);
}
