package modelo;
import java.text.NumberFormat;
import java.util.Locale;
public class Terreno extends Financiamento {
    //Atributos da Classe
    private final String tipoZona;
    //Getters para acessos dos atributos encapsulados
    public String getTipoZona() {
        return tipoZona;
    }
    //Método Construtor
    public Terreno (double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona){
       super (valorImovel, prazoFinanciamento, taxaJurosAnual);
       this.tipoZona = tipoZona;
    }
    //Método para Acréscimo
    public double calcularAcrescimo(){
        double total;
        double total1 = calPagTotal() * 0.02;
        total = calPagTotal() + total1;
        return total;

    }
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    //Método para Display
    public String toString() {
        return "\nTerreno" +
                "\nº Valor do Apartamento: " + currencyFormat.format(getValorImovel()) +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos" +
                "\nº Valor da taxa de juros: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela: " + currencyFormat.format(calcPagMensal()) +
                "\nº Valor do financiamento: " + currencyFormat.format(calPagTotal()) +
                "\nº Valor total com Acréscimo: " + currencyFormat.format(calcularAcrescimo()) +
                "\nº Zona do Terreno: " + getTipoZona();

    }
}