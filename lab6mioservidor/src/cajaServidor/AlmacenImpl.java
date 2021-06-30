/**package cajaServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import caja.comun.*;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject implements Almacen{

	private HashMap mapa;
	private static HashMap mapaVisores;
	private java.rmi.server.RMIClientSocketFactory rmicsf;
	private java.rmi.server.RMIServerSocketFactory rmissf;
	
	protected AlmacenImpl(java.rmi.server.RMIClientSocketFactory rmicsf,  // factory de cliente
	        java.rmi.server.RMIServerSocketFactory rmissf) throws RemoteException {
		super(0, rmicsf, rmissf);
		//crea los dos mapas: el del nombre de la caja- referencia caja ; y el de caja referencia y visores
		mapa=new HashMap<String,CajaImpl> ();
		mapaVisores=new HashMap<CajaImpl,ArrayList> ();
		this.rmicsf=rmicsf;
		this.rmissf=rmissf;
	}
	@Override
	public Caja nuevaCaja(String nombreCaja) throws RemoteException {
		CajaImpl nuevaCaja=new CajaImpl(rmicsf, rmissf);
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
}**/

package cajaServidor;

import caja.comun.Acumulador;
import caja.comun.Almacen;
import caja.comun.Caja;
import caja.comun.Visor;

import java.rmi.RemoteException;
import java.util.*;

public class AlmacenImpl extends java.rmi.server.UnicastRemoteObject
        implements Almacen {
	javax.rmi.ssl.SslRMIClientSocketFactory rmicsf=
			new javax.rmi.ssl.SslRMIClientSocketFactory();
	javax.rmi.ssl.SslRMIServerSocketFactory rmissf=
			new javax.rmi.ssl.SslRMIServerSocketFactory();
	
	
    private static Map<String,CajaImpl> mapa= new HashMap<String,CajaImpl>();
    private static Map<CajaImpl, Set<Visor>> mapavisores = new HashMap<CajaImpl,Set<Visor>>();

    public AlmacenImpl(java.rmi.server.RMIClientSocketFactory rmicsf, //factory de cliente
			java.rmi.server.RMIServerSocketFactory rmissf) throws RemoteException{ //factory de server
        super(0, rmicsf, rmissf); // es el constructor de UnicastRemoteObject.
    }

    public Caja nuevaCaja(String nombreCaja) throws java.rmi.RemoteException {
        CajaImpl caja = new CajaImpl(rmicsf, rmissf);
        mapa.put(nombreCaja,caja);
        return caja;
    }

    public  boolean observaCaja(Visor v, String nombreCaja) throws java.rmi.RemoteException {
        boolean isname = false;
        CajaImpl caja = mapa.get(nombreCaja);
        if (caja != null){
            Set<Visor> visores = mapavisores.get(caja);
            if (visores == null){
                visores = new HashSet<Visor>();
            }
            visores.add(v);
            mapavisores.put(caja,visores);
            isname = true;
        }
        return isname;
    }

    public static void cajaactualizada (CajaImpl caja, Acumulador acumulador) throws java.rmi.RemoteException {
        Set<Visor> visores = mapavisores.get(caja);
        if (visores != null){
            Iterator<Visor> it = visores.iterator();
            while(it.hasNext()){
                it.next().notifica(acumulador);
            }
        }

    }


}



