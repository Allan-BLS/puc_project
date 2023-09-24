//pacote modelo
package modelo;
//Criação da classe Financiamento
public abstract class Financiamento {
    //Criação dos atributos da classe
    private final double valorImovel;
    private final int prazoFinanciamento;
    private double taxaJurosAnual;

    //Getters para acesso dos atributos encapsulados
    public double getValorImovel (){
        return valorImovel;
    }
    public int getPrazoFinanciamento (){
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }
    //Setter para novo valor da Taxa de Juros Anual da classe Casa
    public void setTaxaJurosAnual(double novaTaxaJuros) {
        this.taxaJurosAnual = novaTaxaJuros;
    }

    //Método Construtor
    public Financiamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    //Método para Cálculo do Pagamento Mensal
    public double calcPagMensal() {
        double taxaMensal = (getTaxaJurosAnual()/ 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double parcelaMensal;

        parcelaMensal = getValorImovel() * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        return parcelaMensal;
    }
    //Método para Cálculo do Pagamento Total
    public double calPagTotal(){
        return calcPagMensal() * getPrazoFinanciamento() * 12;
    }
    //Método para Display
    public abstract String toString();
}