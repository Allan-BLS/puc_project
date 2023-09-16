//pacote modelo
package util;
//Importação da classe Scanner para input de dados
import java.util.Scanner;
//Criação da classe InterfaceUsuário
public class InterfaceUsuario {
    //Criação de um objeto da classe Scanner para uso na classe Financiamento
    private final static Scanner scanner = new Scanner(System.in);

    //Método Valor do Imóvel
    public static double valorDoImovel(){
        int imovel;
        do {
            System.out.print("Digite o valor do imovel: ");
            imovel = scanner.nextInt();
            if (imovel <= 0) {
                System.out.println("Valor inválido, por favor digite novamente!");
            }
        }
        while(imovel <= 0);
        return(imovel);
    }
    //Método Prazo de Financiamento
    public static int prazoDeFinanciamento() {
        int financiamento;
        do {
            System.out.print("Digite o prazo de financiamento em anos: ");
            financiamento = scanner.nextInt();
            if (financiamento <= 0) {
                System.out.print("Valor inválido, por favor digite novamente!");
            }
        }
        while (financiamento <= 0);
        return financiamento;
    }
    //Método Taxa de Juros
    public static double taxaDeJuros() {
        double taxaJuros;
        do {
            System.out.print("Digite o valor da taxa de juros: ");
            taxaJuros = scanner.nextDouble();
            if (taxaJuros <= 0 || taxaJuros >= 31) {
                System.out.print("Valor inválido, por favor digite novamente!");
            }
        }
        while (taxaJuros <= 0);
        return taxaJuros;
    }
}