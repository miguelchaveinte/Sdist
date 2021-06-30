package cajaServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;

import caja.comun.Acumulador;
import caja.comun.Caja;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject implements Caja{

	private Acumulador objeto;

	protected CajaImpl() throws RemoteException {
		super();
	}
	
	public void guarda(Acumulador acumulador) throws RemoteException {
		objeto=acumulador;
		AlmacenImpl.cajaActualizada(this, objeto); //notifica el cambio
	}

	
	public Acumulador recupera() throws RemoteException {
		Acumulador retorno=objeto;
		objeto=null;
		AlmacenImpl.cajaActualizada(this, objeto); //notifica el cambio
		return retorno;
	}

}

/**package cajaServidor;

import java.rmi.RemoteException;

import caja.comun.Acumulador;
import caja.comun.Caja;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject implements Caja {
	private Acumulador acum;
    public CajaImpl() throws java.rmi.RemoteException {
	      super(); // es el constructor de UnicastRemoteObject.
  	}
	public void guarda(Acumulador dato) throws RemoteException {
			acum = dato;
			AlmacenImpl.cajaActualizada(this, acum);
	}
	public Acumulador recupera() throws RemoteException {
		Acumulador tmp = acum;
		acum = null;
		AlmacenImpl.cajaActualizada(this, acum);
		return tmp;
	}
}**/
