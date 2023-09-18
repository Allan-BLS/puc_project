//pacote modelo
package util;
//Importação da classe Scanner para input de dados
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
//Criação da classe InterfaceUsuário
public class InterfaceUsuario {
    //Criação de um objeto da classe Scanner para uso na classe Financiamento
    private final static Scanner scanner = new Scanner(System.in);
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    //Método Valor do Imóvel
    public static double valorDoImovel() {
        double valorDoImovel;
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorDoImovel = scanner.nextDouble();
                if (valorDoImovel <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }
                return valorDoImovel;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    //Método Prazo de Financiamento
    public static int prazoDeFinanciamento() {
        int financiamento;
        while (true) {
            try {
                System.out.print("Digite o prazo de financiamento em anos: ");
                financiamento = scanner.nextInt();
                if (financiamento <= 0) {
                    throw new Exception("Valor inválido, por favor digite novamente!\n");
                }
                return financiamento;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            }catch(Exception e){
                System.out.print("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    //Método Taxa de Juros
    public static double taxaDeJuros() {
        double taxaJuros;
        while (true) {
            try {
                System.out.print("Digite o valor da taxa de juros: ");
                taxaJuros = scanner.nextDouble();
                if (taxaJuros <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }
                return taxaJuros;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}