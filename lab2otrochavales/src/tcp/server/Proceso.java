package tcp.server;

@FunctionalInterface
public interface Proceso {
    public String procesaLinea(String linea);
}
