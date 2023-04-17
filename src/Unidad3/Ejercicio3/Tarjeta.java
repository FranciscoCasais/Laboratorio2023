package Unidad3.Ejercicio3;
public class Tarjeta extends MetodoPago {
    private boolean credito,debito;
    private int numero;
    private String banco;
    public Tarjeta() {
        super();
        credito=false;
        debito=false;
        numero=0;
        banco="";
    }
    public boolean getCredito() { return credito; }
    public boolean getDebito() { return debito; }
    public int getNumero() { return numero; }
    public String getBanco() { return banco; }
    public void setCredito(boolean credito) { this.credito=credito; }
    public void setDebito(boolean debito) { this.debito=debito; }
    public void setNumero(int numero) { this.numero=numero; }
    public void setBanco(String banco) { this.banco=banco; }
}