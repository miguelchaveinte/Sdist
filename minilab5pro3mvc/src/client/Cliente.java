
package client;

public class Cliente {
  public static void main(String [] arg) {
    try { // try descaradamente perezoso
      service.HolaControl   c =
         (service.HolaControl) java.rmi.Naming.lookup("SalaReuniones");
      client.HolaVistaImpl v = new client.HolaVistaImpl();
      c.setHola(arg[0], v);
      Thread.sleep(20000); // siete segundos de espera + desregistro
      c.unsetHola(v);
      System.out.println("Despedida y cierre");
      System.exit(0);
    } catch (Exception e) { e.printStackTrace(); }
  }
}
