package modelo;
import java.text.NumberFormat;
import java.util.Locale;
public class Casa extends Financiamento{
    //Atributos da classe
    private static final double descMax = 100.0;
    private double descParcela;
    private final int areaConstruida;
    private final int areaTerreno;

    //Getters para acessos dos atributos encapsulados
    public double getdescMax (){
        return descMax;
    }
    public double getDescParc(){
        return descParcela;
    }
    public double getAreaConstruida() {
        return areaConstruida;
    }
    public double getAreaTerreno() {
        return areaTerreno;
    }

    //Método Construtor
    public Casa (double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int areaTerreno) throws DescontoMaiorDoQueJurosException {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
        descParc();
    }

    //Método para desconto de R$100
    private void descParc() throws DescontoMaiorDoQueJurosException {
        try {
            descParcela = Math.min(calcPagMensal(), getdescMax());
            if (descParcela > getTaxaJurosAnual()) {
                throw new DescontoMaiorDoQueJurosException("Desconto é maior do que taxa de juros anual");
            }
        }catch (DescontoMaiorDoQueJurosException e){
            System.out.print("Erro: " + e.getMessage());
        }
    }
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    // Método para Display
    public String toString() {
        return "\nCasa" +
                "\nº Valor do Apartamento: " + currencyFormat.format(getValorImovel()) +
                "\nº Valor do financiamento: " + currencyFormat.format(calPagTotal()) +
                "\nº Valor da taxa de juros: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela: " + currencyFormat.format(calcPagMensal()) +
                "\nº Parcela com desconto: " + currencyFormat.format(getDescParc()) +
                "\nº Área Construída: " + getAreaConstruida() + "m²" +
                "\nº Área do Terreno: " + getAreaTerreno() + "m²" +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos";
    }
}
