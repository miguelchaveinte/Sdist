package ejemplo.timeprinter;

public class TimePrinter implements Runnable {
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " " + new java.util.Date());
            try { Thread.sleep(1000); // milis
            } catch (InterruptedException x) { }
        }
    }
    public static void main(String[ ] args) {
        final Runnable tarea = new TimePrinter();
        final Runnable tarea2 = new TimePrinter();
        Thread bar=new Thread(tarea, "Hilo de TimePrinter22");
        bar.setPriority(Thread.MAX_PRIORITY);
        bar.start();
        new Thread(tarea2, "Hilo de TimePrinter2").start();

        //resto del programa
    }
}