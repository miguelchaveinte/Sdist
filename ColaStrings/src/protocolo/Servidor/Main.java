package protocolo.Servidor;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaStrings cola = new ColaStrings() ;
        Runnable genera = new Productor(cola) ;
        Runnable come = new Consumidor(cola) ;

        //new Thread(genera).start();
        new Thread(come).start();
       /* try {
			new Thread(genera).sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        new Thread(genera).start();

    }

}
