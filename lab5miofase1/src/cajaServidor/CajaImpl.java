/**package cajaServidor;

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

}**/

package cajaServidor;

import caja.comun.Acumulador;
import caja.comun.Caja;

public class CajaImpl extends java.rmi.server.UnicastRemoteObject implements Caja{
	public caja.comun.Acumulador acumulador;
	public CajaImpl () throws java.rmi.RemoteException{
		super(); //Constructor de UnicastRemoteObject
		this.acumulador = null;
	}

	//Implementa el metodo guarda()
	@Override
	public void guarda(Acumulador acumulador) throws java.rmi.RemoteException{
		
		this.acumulador = acumulador;
		
	}
	
	//Implementa el metodo recupera(), qealiza una lectura destructiva del objeto de tipo caja.comun.Acumulador
	//contenido en el objeto remoto de tipo caja.comun.Caja, produciendo el vaciado 
	//del contenido del objeto remoto.
	
	@Override
	public Acumulador recupera() throws java.rmi.RemoteException{
		// TODO Auto-generated method stub
		caja.comun.Acumulador acum = this.acumulador;
		this.acumulador = null;
		if (acum == null) {
			return null;
		}
		else {
			return acum;
		}
	}

}

