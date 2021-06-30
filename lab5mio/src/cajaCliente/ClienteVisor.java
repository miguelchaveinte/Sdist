package cajaCliente;

import caja.comun.Almacen;

public class ClienteVisor {
    public static void main(String [] args) {
        try {
            Almacen alm = (Almacen) java.rmi.Naming.lookup("//localhost/AlmacenRemoto");
            System.out.println("Objeto 'AlmacenRemoto' :Almacen localizado");
            VisorImpl visor = new VisorImpl();
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
