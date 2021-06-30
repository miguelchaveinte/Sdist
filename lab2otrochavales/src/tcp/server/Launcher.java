package tcp.server;

public class Launcher {
    public static void main(String[] args) throws java.io.IOException {
        Server ser = new Server(2000, (entrada) -> { return entrada; });
        ser.startServer(true);
    }
}
