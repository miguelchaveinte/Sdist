package cajaCliente;

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
