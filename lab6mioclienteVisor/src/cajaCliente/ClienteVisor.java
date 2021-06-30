/**package cajaCliente;

import caja.comun.Almacen;

public class ClienteVisor {
    public static void main(String [] args) {
        try {
        	javax.rmi.ssl.SslRMIClientSocketFactory rmicsf =
                    new javax.rmi.ssl.SslRMIClientSocketFactory();
        	javax.rmi.ssl.SslRMIServerSocketFactory rmissf =
                    new javax.rmi.ssl.SslRMIServerSocketFactory();
        	
              java.rmi.registry.Registry reg =
                    java.rmi.registry.LocateRegistry.getRegistry("localhost", 1100, rmicsf);
              Almacen alm = (Almacen) reg.lookup("AlmacenRemoto");

            System.out.println("Objeto 'AlmacenRemoto' :Almacen localizado");
            VisorImpl visor = new VisorImpl(rmicsf, rmissf);
            
            boolean cajaesta = alm.observaCaja(visor, "MisAhorros");
            if (cajaesta){
                System.out.println("Registrado Visor en 'MisAhorros'");
            } else {
                System.out.println("Caja 'MisAhorros' no existe");
                System.exit(0);
            }
            // el observador se queda ah� a la espera de los mensajes de Almacen.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}**/


package cajaCliente;

import caja.comun.Almacen;

public class ClienteVisor {
    public static void main(String [] args) {
        try {
        	//Se crean las factorias de sockest seguros
        	javax.rmi.ssl.SslRMIClientSocketFactory rmicsf=
					new javax.rmi.ssl.SslRMIClientSocketFactory();
			javax.rmi.ssl.SslRMIServerSocketFactory rmissf=
					new javax.rmi.ssl.SslRMIServerSocketFactory();
			//Se crea el registro seguro
			java.rmi.registry.Registry reg=
			java.rmi.registry.LocateRegistry.getRegistry("localhost", 1099, rmicsf);
			
            Almacen alm = (Almacen) reg.lookup("AlmacenRemoto");
            System.out.println("Objeto 'AlmacenRemoto' :Almacen localizado");
            VisorImpl visor = new VisorImpl(rmicsf,rmissf);  //Por par�metros las factorias de sockets
            boolean cajaesta = alm.observaCaja(visor, "MisAhorros");
            if (cajaesta){
                System.out.println("Registrado Visor en 'MisAhorros'");
            } else {
                System.out.println("Caja 'MisAhorros' no existe");
                System.exit(0);
            }
            // el observador se queda ahí a la espera de los mensajes de Almacen.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


