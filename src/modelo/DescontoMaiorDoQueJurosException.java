package modelo;
import java.io.Serializable;
public class DescontoMaiorDoQueJurosException extends Exception implements Serializable {
    public DescontoMaiorDoQueJurosException(String msg) {
        super(msg);
    }
}
