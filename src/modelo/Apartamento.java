package modelo;
import java.text.NumberFormat;
import java.util.Locale;
import java.io.Serializable;
public class Apartamento extends Financiamento implements Serializable {
    //Atributos da classe
    private final int numVagas;
    private final int numAndar;
    //Getters para acessos dos atributos encapsulados
    public int getNumVagas() {
        return numVagas;
    }
    public int getNumAndar() {
        return numAndar;
    }
    //Método Construtor
    public Apartamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numVagas, int numAndar){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numVagas = numVagas;
        this.numAndar = numAndar;
    }
    //Método para calcular taxa decrescente
    public double calcPagMensal() {
        double taxaJurosMensal = (getTaxaJurosAnual() / 12) / 100;
        int numPagamentos = getPrazoFinanciamento() * 12;
        double taxaDecrescente = (getTaxaJurosAnual()/ numPagamentos) / 100.0;
        return (getValorImovel() / numPagamentos) * (1 + taxaJurosMensal + taxaDecrescente);
    }

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    // Método String para display
    public String toString() {
        return "\nApartamento" +
                "\nº Valor do Apartamento: " + currencyFormat.format(getValorImovel()) +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos" +
                "\nº Valor da taxa de juros: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela: " + currencyFormat.format(calcPagMensal()) +
                "\nº Número de Vagas: " + getNumVagas() +
                "\nº Número do Andar: " + getNumAndar() + "º andar" +
                "\nº Valor do financiamento: " + currencyFormat.format(calPagTotal());
    }
}
