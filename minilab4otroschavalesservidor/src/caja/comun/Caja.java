/**package caja.comun;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Caja extends Remote {

	 void guarda(Acumulador acumulador) throws RemoteException;
	 Acumulador recupera () throws RemoteException;
}**/
package caja.comun;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Caja extends Remote {
    public void guarda(int in)throws RemoteException;
    public int recupera()throws RemoteException;

}
