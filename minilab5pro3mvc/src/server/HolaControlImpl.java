package server;

public class HolaControlImpl extends java.rmi.server.UnicastRemoteObject
        implements service.HolaControl {
  HolaModelo modelo; // el controlador tiene una referencia al modelo

  public HolaControlImpl(HolaModelo modelo)
        throws java.rmi.RemoteException {
    super();
    this.modelo = modelo;
  }
  public void setHola(String saludo, service.HolaVista vista)
        throws java.rmi.RemoteException {
    System.out.println("Saludo de cliente: "+saludo); // printout de depuración
    modelo.setHola(saludo, vista);
    // si estuvieramos en un Web MVC, setHola() podría
    // encargarse de la multidifusión a los observadores.
  }
  public void unsetHola(service.HolaVista vista)
        throws java.rmi.RemoteException {
    System.out.println("Unset de cliente."); // printout de depuración
    modelo.unsetHola(vista);
  }
}
