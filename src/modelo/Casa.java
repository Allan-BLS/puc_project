package modelo;
import java.text.NumberFormat;
import java.util.Locale;
import util.InterfaceUsuario;
import java.io.Serializable;
public class Casa extends Financiamento implements Serializable {
    //Atributos da classe
    private final double descMax = 100;
    private final int areaConstruida;
    private final int areaTerreno;

    //Getters para acessos dos atributos encapsulados
    public double getdescMax() {
        return descMax;
    }
    public double getAreaConstruida() {
        return areaConstruida;
    }
    public double getAreaTerreno() {
        return areaTerreno;
    }

    //Método Construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int areaTerreno){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
        calcJurosMensal();
    }
    //Método para Cálculo do Pagamento Mensal
    public double calcPagMensal(){
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double pagamentoMensal = getValorImovel() * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        if (pagamentoMensal > getdescMax()) {
            pagamentoMensal -= getdescMax();
        }
        return pagamentoMensal;
    }

    public double calcPagMensalSemDesc(){
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        return getValorImovel() * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        }


    //Método para Cálculo do Juros Mensal
    public void calcJurosMensal() {
            int numMeses = getPrazoFinanciamento() * 12;
            double pagMensal = calcPagMensal();
            double jurosMensal;
            jurosMensal = (pagMensal * numMeses) - getValorImovel();
            while (jurosMensal < getdescMax()) {
                try {
                throw new DescontoMaiorDoQueJurosException("Taxa de juros mensal é menor que o valor de desconto.");
                } catch (DescontoMaiorDoQueJurosException e) {
                    System.out.println(e.getMessage());
                    double novaTaxaJuros = InterfaceUsuario.taxaDeJuros();
                    setTaxaJurosAnual(novaTaxaJuros);
                    pagMensal = calcPagMensal();
                    jurosMensal = (pagMensal * numMeses) - getValorImovel();
                }
            }
    }

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    // Método para Display
    public String toString() {
        return "\nCasa" +
                "\nº Valor do Apartamento: " + currencyFormat.format(getValorImovel()) +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos" +
                "\nº Valor da taxa de juros Anual: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela sem desconto: " + currencyFormat.format(calcPagMensalSemDesc()) +
                "\nº Desconto máximo de: " + currencyFormat.format(descMax) +
                "\nº Valor final da parcela: " + currencyFormat.format(calcPagMensal()) +
                "\nº Área do Terreno: " + getAreaTerreno() + "m²" +
                "\nº Área Construída: " + getAreaConstruida() + "m²" +
                "\nº Valor do financiamento: " + currencyFormat.format(calPagTotal());
    }
}
