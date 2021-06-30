package service;

// Observador-Vista en MVC: callback RMI
public interface HolaVista extends java.rmi.Remote {
  public void notify(String[] saludos) throws java.rmi.RemoteException;
}