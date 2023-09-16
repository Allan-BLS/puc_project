package modelo;
import java.text.NumberFormat;
import java.util.Locale;
public class Apartamento extends Financiamento {
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
    public double taxaDesc(int numParc){
        double desconto = 0.0;
        if(numParc == 1){
            desconto = 5.0;
        } else if(numParc == 2){
            desconto = 2.5;
        }
        double valorDesconto = calcPagMensal() * desconto/100.0;
        return calcPagMensal() - valorDesconto;
    }
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    // Método String para display
    public String toString() {
        return "\nApartamento" +
                "\nº Valor do Apartamento: " + currencyFormat.format(getValorImovel()) +
                "\nº Valor do financiamento: " + currencyFormat.format(calPagTotal()) +
                "\nº Valor da taxa de juros: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela: " + currencyFormat.format(calcPagMensal()) +
                "\nº (1ª) Parcela com desconto: " + currencyFormat.format(taxaDesc(1)) +
                "\nº (2ª) Parcela com desconto: " + currencyFormat.format(taxaDesc(2)) +
                "\nº Número de Vagas: " + getNumVagas() +
                "\nº Número do Andar: " + getNumAndar() + "º andar" +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos";
    }
}
