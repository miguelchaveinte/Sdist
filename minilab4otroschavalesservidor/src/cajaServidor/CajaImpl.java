/**package cajaServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;

import caja.comun.Acumulador;
import caja.comun.Caja;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject implements Caja{

	private Acumulador objeto;

	public CajaImpl() throws RemoteException {
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
**/
package cajaServidor;
import caja.comun.*;
public class CajaImpl
    extends java.rmi.server.UnicastRemoteObject
    implements Caja {
    Acumulador ac;

    public CajaImpl() throws java.rmi.RemoteException{
        super();
        ac = null;
    }

    public void guarda(int in) throws java.rmi.RemoteException{
            ac = new Acumulador(in);
    }

    public int recupera() throws java.rmi.RemoteException{
            int valor = ac.valor();
            ac = null;
            return valor;
    }

}