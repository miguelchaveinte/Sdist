package tcp.server;

/*public class Sirviente implements Runnable, AutoCloseable {
    private final java.io.PrintStream   out;
    private final java.io.BufferedReader in;
    private final java.net.Socket s;
    private final Proceso p;
    
    public final int id;
    private static int idSec;
    
    Sirviente(java.net.ServerSocket sS, Proceso p) throws java.io.IOException {
    this.s = sS.accept();
        this.p = p;
        this.id = idSec++;
        this.in   = new java.io.BufferedReader(
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
        out.close();
        in.close();
    }
    
    public void run() {
        try {
            String entrada, salida;
            
            while (null != (entrada = dameLinea())) {
                System.out.println("["+this.id+"] Echoing: " + entrada);
                salida = this.p.procesaLinea(entrada);
                ponLinea(salida);
            }
        } catch (java.net.SocketException se) {
        System.err.println("Conexion cerrada por el host cliente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Sirviente implements Runnable, AutoCloseable {
    private final java.io.PrintStream   out;
    private final java.io.BufferedReader in;
    private final java.net.Socket s;
    private final Proceso p;
    private final int indice;

    public final int id;
    private static int idSec;

    Sirviente(java.net.ServerSocket sS, Proceso p , int indice) throws java.io.IOException {
    this.s = sS.accept();
        this.p = p;
        this.id = idSec++;
        this.in   = new java.io.BufferedReader(
                          new java.io.InputStreamReader(s.getInputStream()));
        this.out = new java.io.PrintStream(s.getOutputStream());
        this.indice = indice;
    }

    String dameLinea() throws java.io.IOException {
        return in.readLine();
    }

    void ponLinea(String linea) throws java.io.IOException {
        out.println(linea);
    }
   
    public void close() throws java.io.IOException {
        out.close();
        in.close();
    }

    public void run() {
        try {
            String entrada, salida , mensajeSalida;
        	int numeroLineas = 0;
        	File archivo = new File("fichero.txt");
        	FileWriter escritor = new FileWriter(archivo , true	);
        	PrintWriter salida2 = new PrintWriter(escritor); 
            while (null != (entrada = dameLinea())) {
            	numeroLineas++;
            	entrada = this.indice +" :"+ entrada;
            	
            	escribir(entrada, salida2);
               
            	mensajeSalida = "Proceso "+this.indice+" lleva escritas "+numeroLineas+" lineas";
                salida = this.p.procesaLinea(mensajeSalida);
                ponLinea(salida);
            }
            
        } catch (java.net.SocketException se) {
        System.err.println("Conexion cerrada por el host cliente");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    public synchronized static void escribir( String entrada , PrintWriter fichero) {
    	
    	try {
		
			//fichero.append(entrada + "\n");
			fichero.write(entrada+ "\n");
			fichero.flush();
		

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
    	
    	
    
	}
}

