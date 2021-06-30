package cajaCliente;

import caja.comun.Acumulador;
import caja.comun.Almacen;
import caja.comun.Caja;

public class ClienteFase1 {
    public static void main(String [] args) {
        try {
            //Almacen alm = (Almacen) java.rmi.Naming.lookup("//localhost/AlmacenRemoto");
        	Almacen alm = (Almacen) java.rmi.Naming.lookup("//localhost/ObjetoAlmacen");
            System.out.println("Objeto 'AlmacenRemoto' :Almacen localizado");
            System.out.println("Fabrico nueva Caja 'MisAhorros'");
            Caja caja = alm.nuevaCaja("MisAhorros");
            System.out.println("Recupero el contenido");
            if (null == caja.recupera())
                System.out.println("La caja 1 esta vacia");
            Acumulador a1 = new Acumulador(1000); // tengo 1000 calcetines
            System.out.println("Guardo un acumulador con 1000");
            caja.guarda(a1);
            System.out.println("Recupero un acumulador con 1000");
            Acumulador a2 = caja.recupera(); // recupero sobre otra variable
            System.out.println("El acumulador recuperado contiene: "+a2.valor());
            System.out.println("FIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
