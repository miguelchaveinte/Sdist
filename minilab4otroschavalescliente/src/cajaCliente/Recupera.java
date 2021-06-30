/**package cajaCliente;

import java.rmi.Naming;

import caja.comun.Acumulador;

public class Recupera {
	public static void main(String [ ] args) {
	    try {
	    	Acumulador acumulador;
	    	caja.comun.Caja or= (caja.comun.Caja) Naming.lookup("rmi://localhost/ObjetoCaja");
	    	acumulador = or.recupera();
	    	if(acumulador!=null) {
	    		System.out.println("El valor del acumulador es: "+ acumulador.valor());
	    	}
	    	else {
	    		System.out.println("El acumulador es vacío");
	    	}

	      } catch (java.rmi.RemoteException re) {
	         System.err.println("<Cliente: Excepción RMI: "+re);
	         re.printStackTrace();
	      } catch (Exception e) {
	         System.err.println("<Cliente: Excepcion: "+e);
	         e.printStackTrace();
	      }
	   }
}
**/
package cajaCliente;

import java.rmi.Naming;
import caja.comun.*;

public class Recupera{
    public static void main(String [ ] args) {
        String host = (args.length < 1) ? null : args[0];
        Acumulador acumula;
        try {
            Caja caja = (Caja) Naming.lookup("rmi://"+host+"/ObjetoCaja");
            acumula =new Acumulador(caja.recupera());
            System.out.println("Objeto recuperado, valor: "+acumula.valor()+", fin de programa");
        } catch (java.rmi.RemoteException re) {
            System.err.println("<Cliente: Excepción RMI: "+re);
            re.printStackTrace();
        } catch (Exception e) {
            System.err.println("<Cliente: Excepcion: "+e);
            e.printStackTrace();
        }
    }
}
