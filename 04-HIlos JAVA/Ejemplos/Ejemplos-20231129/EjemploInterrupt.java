public class EjemploInterrupt extends Thread {

    public void run() {
        while (!Thread.interrupted()) { // Comprobar el estado de interrupción
            // Realiza la tarea; en este caso, solo imprime un mensaje
            System.out.println("El hilo está corriendo...");
            try {
                // Dormir durante un tiempo para simular una tarea que lleva tiempo
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Esta línea solo se ejecuta si el hilo está dormido y es interrumpido
                System.out.println("El hilo fue interrumpido durante el sueño.");
                // Si no se maneja la interrupción aquí, podría reiniciar la bandera de estado
                // o simplemente terminar el hilo (break).
                break;
            }
            // Puedes poner más código aquí que también podría responder a la interrupción
        }
        System.out.println("El hilo ha terminado de ejecutarse.");
    }

    public static void main(String[] args) {
        EjemploInterrupt hilo = new EjemploInterrupt();
        hilo.start();

        // Darle tiempo al hilo para que comience y realice algo de trabajo
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrumpir el hilo después de un tiempo
        hilo.interrupt();
    }
}
