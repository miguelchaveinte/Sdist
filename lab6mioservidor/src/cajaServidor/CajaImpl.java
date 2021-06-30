/**package cajaServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;

import caja.comun.Acumulador;
import caja.comun.Caja;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject implements Caja{

	private Acumulador objeto;

	protected CajaImpl(java.rmi.server.RMIClientSocketFactory rmicsf,  // factory de cliente
	        java.rmi.server.RMIServerSocketFactory rmissf) throws RemoteException {
		super(0, rmicsf, rmissf);
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

}**/

package cajaServidor;

import caja.comun.Acumulador;
import caja.comun.Caja;

import java.rmi.RemoteException;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject
        implements Caja {
    private Acumulador acumulador;
   
    public CajaImpl(java.rmi.server.RMIClientSocketFactory rmicsf, //factory de cliente
			java.rmi.server.RMIServerSocketFactory rmissf) throws RemoteException{ //factory de server) throws RemoteException {
        super(0, rmicsf, rmissf); // es el constructor de UnicastRemoteObject.
        acumulador=null;
    }

    public void guarda(Acumulador a) throws RemoteException {
        this.acumulador = a;
        AlmacenImpl.cajaactualizada(this, a);

    }
    public Acumulador recupera() throws RemoteException {
        Acumulador salida = acumulador;
        acumulador = null;
        AlmacenImpl.cajaactualizada(this, null);
        return salida;
    }

}




