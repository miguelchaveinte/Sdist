/**package cajaServidor;

public class Launcher {
	public static void main(String [ ] args) {
	      try {
	    	  //Creamos el objeto remoto
	         AlmacenImpl oRemoto = new AlmacenImpl();
	         
	         // Accedemos a una referencia al registro (rmiregistry) local
	         java.rmi.registry.Registry registro =
	            java.rmi.registry.LocateRegistry.getRegistry("localhost");
	          
	         // registramos el objeto, hablaremos más adelante de re-bind
	         registro.rebind("AlmacenRemoto", oRemoto);

	         System.err.println("Servidor preparado");
	      } catch (Exception e) {
	         System.err.println("Excepción del servidor: "+e.toString());
	         e.printStackTrace();
	      }
	   }
}**/

package cajaServidor;


public class Launcher {

   public static void main(String [ ] args) {

      try {

         cajaServidor.AlmacenImpl almRemoto = new AlmacenImpl();
         
         

         // Accedemos a una referencia al registro (rmiregistry) local

        /* java.rmi.registry.Registry registro =

            java.rmi.registry.LocateRegistry.getRegistry("localhost");*/

         java.rmi.registry.Registry registro =

                 java.rmi.registry.LocateRegistry.createRegistry(1099);

         // registramos el objeto, hablaremos más adelante de re-bind

         registro.rebind("ObjetoAlmacen", almRemoto);
         System.out.println("Objeto remoto 'ObjetoAlmacen' enlazado");
         System.err.println("Servidor preparado");

      } catch (Exception e) {

         System.err.println("Excepción del servidor: "+e.toString());

         e.printStackTrace();

      }

   }

}
