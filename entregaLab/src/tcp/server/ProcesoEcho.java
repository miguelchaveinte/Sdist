package tcp.server;

public class ProcesoEcho implements Proceso {
    public String procesaLinea(String linea)  {
        // aqu� se produce el procesamiento
        return linea; // en el ejemplo Echo.
    }
}