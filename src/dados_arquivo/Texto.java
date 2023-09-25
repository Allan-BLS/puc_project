package dados_arquivo;
import modelo.Financiamento;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Texto {
    public static void salvarDados(ArrayList<Financiamento> listaFinanciamento) throws IOException {
        FileWriter out;
        try {
            out = new FileWriter("Dados_Financiamento.txt");
            for (Financiamento financiamento : listaFinanciamento) {
                out.write(financiamento.toString() + "\n");
            }
            System.out.println("Seus dados foram salvos com sucesso!\n");
            out.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lerDados(ArrayList<Financiamento> listaFinanciamento) throws IOException {
        FileReader in;
        try {
            System.out.println("Abrindo leitura do arquivo Dados_Financiamento.txt:");
            in = new FileReader("Dados_Financiamento.txt");
            int c;
            while ((c = in.read()) != -1)
                System.out.print((char)c);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
