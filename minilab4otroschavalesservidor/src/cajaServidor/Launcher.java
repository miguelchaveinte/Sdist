/**package cajaServidor;

public class Launcher {
	public static void main(String [ ] args) {
	      try {
	         CajaImpl oRemoto = new CajaImpl();
	         
	         // Accedemos a una referencia al registro (rmiregistry) local
	         java.rmi.registry.Registry registro =
	            java.rmi.registry.LocateRegistry.getRegistry("localhost");
	          
	         // registramos el objeto, hablaremos más adelante de re-bind
	         registro.rebind("ObjetoCaja", oRemoto);

	         System.err.println("Servidor preparado");
	      } catch (Exception e) {
	         System.err.println("Excepción del servidor: "+e.toString());
	         e.printStackTrace();
	      }
	   }
}
**/
package cajaServidor;

public class Launcher{
    public static void main(String[] args){
        try{

            CajaImpl or = new CajaImpl();
            java.rmi.registry.Registry registro =
                java.rmi.registry.LocateRegistry.getRegistry("localhost");

            registro.rebind("ObjetoCaja", or);
            System.err.println("Servidor preparado");
        }catch(Exception e) {
            System.err.println("Excepción del servidor: "+e.toString());
            e.printStackTrace();
        }
    }
}