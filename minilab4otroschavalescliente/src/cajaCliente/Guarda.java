/**package cajaCliente;

import java.rmi.Naming;

import caja.comun.Acumulador;

public class Guarda {
	public static void main(String [ ] args) {
		String argumento = (args.length < 1) ? null : args[0];
		int valor;
		if(argumento!=null) {
			valor=Integer.parseInt(argumento);
		}
		else {
			valor=10;
		}
	    try {
	    	Acumulador acumulador =new Acumulador(valor);
	    	caja.comun.Caja or= (caja.comun.Caja) Naming.lookup("rmi://localhost/ObjetoCaja");
	    	or.guarda(acumulador);
	    	System.out.println("Se guardó correctamente el acumulador");

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

public class Guarda{

    public static void main(String [ ] args) {
        String host = (args.length < 1) ? null : args[0];
        Acumulador acumula = new Acumulador(Integer.parseInt(args[1]));
        try {
            Caja caja = (Caja) Naming.lookup("rmi://"+host+"/ObjetoCaja");
            caja.guarda(acumula.valor());
            System.out.println("Objeto guaradado, fin de programa");
        } catch (java.rmi.RemoteException re) {
            System.err.println("<Cliente: Excepción RMI: "+re);
            re.printStackTrace();
        } catch (Exception e) {
            System.err.println("<Cliente: Excepcion: "+e);
            e.printStackTrace();
        }
    }
}

