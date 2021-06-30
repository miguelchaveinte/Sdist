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
	}

	
	public Acumulador recupera() throws RemoteException {
		Acumulador retorno=objeto;
		objeto=null;
		return retorno;
	}

}
