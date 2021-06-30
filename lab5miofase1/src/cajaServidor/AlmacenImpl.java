/**package cajaServidor;

import java.rmi.RemoteException;
import java.util.HashMap;

import caja.comun.*;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject implements Almacen{

	private HashMap mapa;
	protected AlmacenImpl() throws RemoteException {
		super();
		//Creo el mapa que guardará la relación nombre caja -caja referencia
		mapa=new HashMap<String,CajaImpl> ();
	}
	@Override
	public Caja nuevaCaja(String nombreCaja) throws RemoteException {
		//Creo una nueva caja y la guardo en el mapa
		CajaImpl nuevaCaja=new CajaImpl();
		mapa.put(nombreCaja, nuevaCaja);
		return nuevaCaja;
	}
}**/
package cajaServidor;

import java.rmi.RemoteException;
import java.util.HashMap;

import caja.comun.Almacen;
import caja.comun.Caja;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject implements Almacen{

	private HashMap<String, CajaImpl> mapa;
	
	protected AlmacenImpl() throws RemoteException {
		super();
		this.mapa = new HashMap<String, CajaImpl>();
	}

	@Override
	public Caja nuevaCaja(String nombreCaja) {
		try {
			cajaServidor.CajaImpl caja = new CajaImpl();
			mapa.put(nombreCaja, caja);
			return caja;
		}catch(RemoteException ex) {
			System.err.println("Excepción del objeto remoto: "+ex.toString());
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
