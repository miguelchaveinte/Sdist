package tcp.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Sirviente implements Runnable, AutoCloseable {
    private final java.io.PrintStream out;
    private final java.io.BufferedReader in;
    private final java.net.Socket s;
    private final Proceso p;
    public final int id;
    private static int idSec;
    private static BufferedWriter salida;
    Sirviente(java.net.ServerSocket sS, Proceso p) throws java.io.IOException {
        this.s = sS.accept();
        this.p = p;
        this.id = idSec++;
        this.in = new java.io.BufferedReader(
                new java.io.InputStreamReader(s.getInputStream()));
        this.out = new java.io.PrintStream(s.getOutputStream());
    }
    String dameLinea() throws java.io.IOException {
        return in.readLine();
    }
    void ponLinea(String linea) throws java.io.IOException {
        out.println(linea);
    }
    public void close() throws java.io.IOException {
        salida.close();
    	out.close();
        in.close();
    }
    public void run() {
        try {
            String entrada, salida;
            int contador=0;
            while (null != (entrada = dameLinea())) {
            	contador++;        	
                System.out.println("["+this.id+"] Echoing: " + entrada);
                salida = this.p.procesaLinea(entrada);
                String paraFich=entrada+":"+this.id+"\n";
                escribeFich(paraFich);
                ponLinea("Número de línea leidas:"+String.valueOf(contador));
            }
        } catch (java.net.SocketException se) {
            System.err.println("Conexion cerrada por el host cliente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    public static synchronized void escribeFich(String entrada) {
    	try {
    		salida= new BufferedWriter(new FileWriter("nuevoLabSdis.txt",true));
			salida.write(entrada);
    		salida.flush();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
