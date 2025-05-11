package trabalho;
// representa a moeda real
class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }
    //converte o valor definido nas classes para o real 
    @Override
    public double converterParaReal() {
        return valor;
    }
    // mostra o valor do real com duas casas decimais
    @Override
    public String toString() {
        return String.format("Moeda: Real | Valor: %.2f", valor);
    }
}