/**package cajaServidor;

public class Launcher {
	public static void main(String [ ] args) {
	      try {  
	         javax.rmi.ssl.SslRMIClientSocketFactory rmicsf =
	                 new javax.rmi.ssl.SslRMIClientSocketFactory();
	          javax.rmi.ssl.SslRMIServerSocketFactory rmissf =
	                 new javax.rmi.ssl.SslRMIServerSocketFactory();

	          // creamos un registro que permita sockets seguros
	          java.rmi.registry.Registry r =
	             java.rmi.registry.LocateRegistry.createRegistry(1100, rmicsf, rmissf);
	          
	          AlmacenImpl oRemoto = new AlmacenImpl(rmicsf, rmissf);
	          
	         // registramos el objeto, hablaremos más adelante de re-bind
	         r.rebind("AlmacenRemoto", oRemoto);

	         System.err.println("Servidor preparado");
	      } catch (Exception e) {
	         System.err.println("Excepción del servidor: "+e.toString());
	         e.printStackTrace();
	      }
	   }
}
**/

package cajaServidor;
import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Launcher {
    public static void main(String [ ] args) {
        try {
            javax.rmi.ssl.SslRMIClientSocketFactory rmicsf=
					new javax.rmi.ssl.SslRMIClientSocketFactory();
			javax.rmi.ssl.SslRMIServerSocketFactory rmissf=
					new javax.rmi.ssl.SslRMIServerSocketFactory();
			
            java.rmi.registry.Registry registro =
                    java.rmi.registry.LocateRegistry.createRegistry(1099,rmicsf,rmissf);
            
            AlmacenImpl oRemoto = new AlmacenImpl(rmicsf,rmissf);

            // registramos el objeto, hablaremos más adelante de re-bind
            registro.rebind("AlmacenRemoto", oRemoto);

            System.err.println("Servidor preparado");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: "+e.toString());
            e.printStackTrace();
        }
    }
}
