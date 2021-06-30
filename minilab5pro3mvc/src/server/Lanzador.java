
package server;

public class Lanzador {
   public static void main(String[] args) {
     try {
       HolaModelo saludos = new HolaModelo();
       HolaControlImpl controlador = new HolaControlImpl(saludos);

       java.rmi.registry.Registry registro =
          java.rmi.registry.LocateRegistry.createRegistry(1099);

       registro.rebind("SalaReuniones", controlador);
       System.out.println("Objeto remoto 'SalaReuniones' enlazado");
     } catch (java.rmi.RemoteException re) {
       re.printStackTrace(System.err);
     } catch (Exception e) {
       e.printStackTrace(System.err);
     }
   }
}