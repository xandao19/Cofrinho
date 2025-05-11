package trabalho;
// representa o euro e define a cotação a ser usado
class Euro extends Moeda {
    private static final double COTACAO_EURO_PARA_REAL = 5.50;
    
    public Euro(double valor) {
        super(valor);
    }
 // converte o euro apartir da cotação definida 
    @Override
    public double converterParaReal() {
        return valor * COTACAO_EURO_PARA_REAL;
    }
    // mostra o valor do euro com duas casas decimais
    @Override
    public String toString() {
        return String.format("Euro: %.2f", valor);
    }
}
