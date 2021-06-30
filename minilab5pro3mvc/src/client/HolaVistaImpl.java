
package client;

public class HolaVistaImpl extends java.rmi.server.UnicastRemoteObject
  implements service.HolaVista {
  public HolaVistaImpl() throws java.rmi.RemoteException {
    super();
  }
  // recibe un array con los saludos de la sala de reuniones y lo imprime.
  public void notify(String[] saludos) throws java.rmi.RemoteException {
    for (String saludo : saludos)
       System.out.println(saludo);
    System.out.println("--------------fin de saludos");
  }
}