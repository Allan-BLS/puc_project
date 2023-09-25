package dados_arquivo;
import modelo.Financiamento;
import java.io.*;
import java.util.ArrayList;

public class Serializado {
    public static void salvarDadosSerializados(ArrayList<Financiamento> listaFinanciamento, String Dados_Financiamento) throws IOException {
        ObjectOutputStream outputStream;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(Dados_Financiamento));
            outputStream.writeObject(listaFinanciamento);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Financiamento> lerDadosSerializados(String Dados_Financiamento) {
        ObjectInputStream inputStream;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(Dados_Financiamento));
            return (ArrayList<Financiamento>)inputStream.readObject();
        } catch (IOException| ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}


