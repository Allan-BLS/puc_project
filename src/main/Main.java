//pacote main
package main;
//Importação das classes
import modelo.*;
import util.InterfaceUsuario;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static dados_arquivo.Serializado.lerDadosSerializados;
import static dados_arquivo.Serializado.salvarDadosSerializados;

//Criação da classe Main
public class Main {
    //Começo do programa
    public static void main(String[] args) throws IOException {
        //Criação da lista
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>();

        double valorImovel = InterfaceUsuario.valorDoImovel();
        int prazoFinanciamento = InterfaceUsuario.prazoDeFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.taxaDeJuros();

        //Criação de um novo objeto da classe por Polimorfismo
        listaFinanciamento.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 120, 400));
        listaFinanciamento.add(new Casa(400000, 30, 8, 120, 300));
        listaFinanciamento.add(new Apartamento(700000, 15, 5, 2, 8));
        listaFinanciamento.add(new Apartamento(350000, 5, 10, 2, 3));
        listaFinanciamento.add(new Terreno(1000000, 30, 13, "Residencial"));
        listaFinanciamento.add(new Terreno(875000, 20, 7, "Comercial"));

        //Para o display da lista
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        //Laço para display
        for (Financiamento contador : listaFinanciamento) {
            System.out.println(contador);

            totalImoveis += contador.getValorImovel();
            totalFinanciamentos += contador.calPagTotal();
        }
        //Display dos valores totais dos financiamentos
        System.out.println("\n==============TOTAL==============");
        System.out.println("Total de todos os imóveis: " + currencyFormat.format(totalImoveis));
        System.out.println("Total de todos os financiamentos: " + currencyFormat.format(totalFinanciamentos));

        //Opção para salvar os dados
        System.out.println("============================\n");

        //Salvar/Ler Dados_Texto
        dados_arquivo.Texto.salvarDados((listaFinanciamento));
        dados_arquivo.Texto.lerDados((listaFinanciamento));

        //Salvar/Ler Dados_Serializado
        salvarDadosSerializados(listaFinanciamento,"Dados_Financiamento_Serializados.ser");
        String dados = String.valueOf(lerDadosSerializados("Dados_Financiamento_Serializados.ser"));
        System.out.println(dados);

    }
}