package EjerciciosInterfaces.SistemaIntercambio;
public class Estado {
    private int manchas,roturas;
    public Estado() {
        manchas=0;
        roturas=0;
    }
    public Estado(int manchas,int roturas) {
        this.manchas=manchas;
        this.roturas=roturas;
    }
    public int getManchas() { return manchas; }
    public void setManchas(int manchas) { this.manchas=manchas; }
    public int getRoturas() { return roturas; }
    public void setRoturas(int roturas) { this.roturas=roturas; }
    public String toString() { return "Manchas: "+manchas+"\nRoturas: "+roturas; }
}