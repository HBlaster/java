package mundopc.modelo;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private Double tamanio;
    private static int contadorMonitores;

    private Monitor(){
        idMonitor= ++contadorMonitores;
    }

    //Constructor public
    public Monitor(String marca, double tamanio){
        this();
        this.marca=marca;
        this.tamanio =tamanio;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "idMonitor=" + idMonitor +
                ", marca='" + marca + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
