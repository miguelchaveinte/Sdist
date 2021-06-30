package cajaCliente;

import java.rmi.RemoteException;
import java.util.HashMap;

import caja.comun.Acumulador;
import caja.comun.Visor;
//import cajaServidor.CajaImpl;

public class VisorImpl extends java.rmi.server.UnicastRemoteObject implements Visor {

	protected VisorImpl(java.rmi.server.RMIClientSocketFactory rmicsf,  // factory de cliente
	        java.rmi.server.RMIServerSocketFactory rmissf) throws RemoteException {
		super(0, rmicsf, rmissf);
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


