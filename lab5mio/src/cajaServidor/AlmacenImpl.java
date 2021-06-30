package cajaServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import caja.comun.*;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject implements Almacen{

	private HashMap mapa;
	private static HashMap mapaVisores;
	protected AlmacenImpl() throws RemoteException {
		super();
		//crea los dos mapas: el del nombre de la caja- referencia caja ; y el de caja referencia y visores
		mapa=new HashMap<String,CajaImpl> ();
		mapaVisores=new HashMap<CajaImpl,ArrayList> ();
	}
	@Override
	public Caja nuevaCaja(String nombreCaja) throws RemoteException {
		CajaImpl nuevaCaja=new CajaImpl();
		mapa.put(nombreCaja, nuevaCaja);	// añade al mapa el nombre y la referencia
		return nuevaCaja;
	}
	@Override
	public boolean observaCaja(Visor visor, String nombreCaja) throws RemoteException {
		if(!mapa.containsKey(nombreCaja)) return false;	// si no hay cajaImpl con ese nombre retorna false
		CajaImpl cajaAsociada= (CajaImpl) mapa.get(nombreCaja);
		if(mapaVisores.containsKey(cajaAsociada)) {			//compruebo que la referencia de la caja esta en el mapa con los visores asociados a esta
			ArrayList visoresAsociados=(ArrayList) mapaVisores.get(cajaAsociada);
			visoresAsociados.add(visor);
			mapaVisores.replace(cajaAsociada, visoresAsociados);
		}
		else {													//la referenccia a la caja no esta en el mapa
			ArrayList visoresAsociados=new ArrayList<Visor> ();
			visoresAsociados.add(visor);
			mapaVisores.put(cajaAsociada, visoresAsociados);
		}
		return true;
	}

	public static void cajaActualizada(CajaImpl caja,Acumulador a) throws RemoteException {
		// dados la caja recorremos todos sus visores asociados y notificamos los cambios
		ArrayList <Visor> visoresAsociados= (ArrayList) mapaVisores.get(caja);
		if(visoresAsociados!=null && !visoresAsociados.isEmpty() ) {
			Iterator<Visor> iter= visoresAsociados.iterator();
			while (iter.hasNext()) {
				 iter.next().notifica(a);
			}
		}
	}
}

/**package cajaServidor;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import caja.comun.Acumulador;
import caja.comun.Almacen;
import caja.comun.Caja;
import caja.comun.Visor;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject implements Almacen{
	private HashMap<String, CajaImpl> mapa;
	private static HashMap<CajaImpl,Set<Visor>> mapavisores;
    public AlmacenImpl() throws java.rmi.RemoteException {
	      super(); // es el constructor de UnicastRemoteObject.
	      mapa=new HashMap<String,CajaImpl> ();
	      mapavisores=new HashMap<CajaImpl,Set<Visor>> ();
	}

	public Caja nuevaCaja(String nombreCaja) throws RemoteException {
		CajaImpl caja = new CajaImpl();
		mapa.put(nombreCaja, caja);
		return caja;
	}
	public boolean observaCaja(Visor v, String nombreCaja) throws RemoteException {
		if(mapavisores.containsKey(mapa.get(nombreCaja))) {
			Set<Visor> tmp = new HashSet<>();
			tmp.add(v);
			mapavisores.put(mapa.get(nombreCaja),tmp);
			
			return true;
		}else
			return false;
	}
	
	public static void cajaActualizada(CajaImpl impl,Acumulador acum) throws RemoteException {
		Set<Visor> set = mapavisores.get(impl);
		if(set!=null && !set.isEmpty()) {
		for(Visor v : set)
			v.notifica(acum);
		}
	}
}**/

