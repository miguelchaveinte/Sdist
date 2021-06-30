/**package caja.comun;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Caja extends Remote {

	 void guarda(Acumulador acumulador) throws RemoteException;
	 Acumulador recupera () throws RemoteException;
}**/
package caja.comun;

public interface Caja extends java.rmi.Remote {
    public void guarda(Acumulador a) throws java.rmi.RemoteException ;
    public Acumulador  recupera() throws java.rmi.RemoteException ;
}
