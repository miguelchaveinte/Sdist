package cajaCliente;

import caja.comun.Acumulador;
import caja.comun.Almacen;
import caja.comun.Caja;

public class ClienteModifica {
    public static void main(String [] args) {
        try {
            Almacen alm = (Almacen) java.rmi.Naming.lookup("//localhost/AlmacenRemoto");
            System.out.println("Objeto 'AlmacenRemoto' :Almacen localizado");
            System.out.println("Fabrico nueva Caja 'MisAhorros'");
            Caja caja = alm.nuevaCaja("MisAhorros");
            System.out.print("Pulsa <Enter> "); System.in.read();
            System.out.println("Recupero el contenido");
            if (null == caja.recupera())
                System.out.println("La caja 1 esta vacia");
            Acumulador a = new Acumulador(1000); // tengo 1000 calcetines
            System.out.println("Guardo un acumulador con 1000");
            caja.guarda(a);
            System.out.print("Pulsa <Enter> "); System.in.read();
            System.out.println("Recupero un acumulador con 1000");
            a = caja.recupera(); // recupero sobre otra variable
            System.out.println("El acumulador recuperado contiene: "+a.valor());
            System.out.print("Pulsa <Enter> "); System.in.read();
            a.incrementa();
            System.out.println("Incremento el acumulador : "+a.valor()+" y guardo");
            caja.guarda(a);
            System.out.println("FIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
