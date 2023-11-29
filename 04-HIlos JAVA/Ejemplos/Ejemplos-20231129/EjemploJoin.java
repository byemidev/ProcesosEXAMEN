public class EjemploJoin extends Thread {
    private String nombre;
    private long tiempoEspera;

    public EjemploJoin(String nombre, long tiempoEspera) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
        System.out.println(nombre + " ha comenzado.");
        try {
            // Simula alguna tarea haciendo que el hilo duerma.
            Thread.sleep(tiempoEspera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + " ha completado su ejecución.");
    }

    public static void main(String[] args) {
        EjemploJoin hilo1 = new EjemploJoin("Hilo1", 5000);
        EjemploJoin hilo2 = new EjemploJoin("Hilo2", 10000);
        EjemploJoin hilo3 = new EjemploJoin("Hilo3", 15000);

        try {
            hilo1.start(); // Inicia hilo1

            // Espera indefinidamente a que hilo1 termine
            hilo1.join();
            System.out.println("Hilo1 ha finalizado, continuando con los demás hilos.");

            hilo2.start(); // Inicia hilo2
            hilo3.start(); // Inicia hilo3

            // Espera a que hilo2 termine o hasta que transcurran 3000 milisegundos
            hilo2.join(3000);
            if (hilo2.isAlive()) {
                System.out.println("Hilo2 todavía está en ejecución después de 3 segundos desde que hilo1 terminó. Esperando a que hilo2 termine...");
                hilo2.join(); // Espera a que hilo2 termine después del primer tiempo de espera.
            }

            // Espera indefinidamente a que hilo3 termine
            hilo3.join();
            System.out.println("Todos los hilos han terminado su ejecución.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

