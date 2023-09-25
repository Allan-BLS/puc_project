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
    public static ArrayList<Financiamento> lerDadosSerializados(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream;
        ArrayList<?> listaDeserializada = new ArrayList<>();
        try {
            inputStream = new ObjectInputStream(new FileInputStream(arquivo));
            listaDeserializada = (ArrayList<?>) inputStream.readObject();
            inputStream.close();
        } catch (EOFException ex) {
            System.out.println(ex.getMessage());
        }

        // Criar uma nova lista do tipo ArrayList<Financiamento>
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>();

        // Adicionar os elementos verificados à nova lista
        for (Object item : listaDeserializada) {
            if (item instanceof Financiamento) {
                listaFinanciamento.add((Financiamento) item);
            }
        }
        return listaFinanciamento;
    }
}


