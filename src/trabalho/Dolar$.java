package trabalho;
// representa o dólar e precifica a cotação
class Dolar extends Moeda {
    private static final double cotacao=5.00;

    public Dolar(double valor, double cotacao) {
        super(valor);
      
    }
    // converte o valor de acordo com a cotação definida
    @Override
    public double converterParaReal() {
        return valor * cotacao;
    }
}