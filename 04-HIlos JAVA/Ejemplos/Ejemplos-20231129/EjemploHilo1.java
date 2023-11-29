public class EjemploHilo1 extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                Thread.sleep(1000); // Dormir por un segundo
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
    }

    public static void main(String[] args) {
        EjemploHilo1 hilo1 = new EjemploHilo1();
        hilo1.start(); // Inicia el hilo que cuenta números
    }
}
