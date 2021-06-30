
package service;

public interface HolaControl extends java.rmi.Remote {
  public void setHola(String saludo, HolaVista vista)
      throws java.rmi.RemoteException;
  public void unsetHola(HolaVista vista) throws java.rmi.RemoteException;
}