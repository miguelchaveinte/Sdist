package cajaCliente;

import java.rmi.RemoteException;
import java.util.HashMap;

import caja.comun.Acumulador;
import caja.comun.Visor;
import cajaServidor.CajaImpl;

public class VisorImpl extends java.rmi.server.UnicastRemoteObject implements Visor {

	protected VisorImpl() throws RemoteException {
		super();
	}
	@Override
	public void notifica(Acumulador a) throws RemoteException {
		//Tiene en cuenta si el acumulador es null
		if(a!=null) {
			System.out.println("El valor del acumulador es: "+ a.valor());
		}
		else {
			System.out.println("El valor del acumulador es: null");
		}
		
	}

}

/**package cajaCliente;

import java.rmi.RemoteException;

import caja.comun.Acumulador;
import caja.comun.Visor;

public class VisorImpl extends java.rmi.server.UnicastRemoteObject implements Visor{
	public VisorImpl() throws java.rmi.RemoteException {
	      super(); // es el constructor de UnicastRemoteObject.
	}
	
	public void notifica(Acumulador a) throws RemoteException {
		System.out.println(a.valor());
	}
}**/

