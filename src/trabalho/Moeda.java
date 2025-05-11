package trabalho;
// serve como base para todas as moedas 
abstract class Moeda {
	//  armazena as moedas adicionadas
    protected double valor;
    
    public Moeda(double valor) {
        this.valor = valor;
    }
    //converte cada moeda de acordo com os critérios definidos nas classes 
    public abstract double converterParaReal();
    //retorna o valor da moeda
    public double getValor() {
        return valor;
    }
    //representação da moeda e exibe o valor com duas casas decimais 
    @Override
    public String toString() {
        return String.format("%.2f", valor);
    }
}
