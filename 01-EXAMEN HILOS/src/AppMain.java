/**
 * Goethe E. Arevalo Zuñiga
 * Main class
 * Vamos a simular una carrera entre una liebre y una tortuga.

El programa principal debe crear debe crear tres hilos, reloj, liebre, tortuga.
El programa principal cuando acaben los corredores debe mostrar cuando a avanzado cada uno y quien ha ganado la carrera (1punto)
 */
public class AppMain {
    public static void main(String[] args) {
    
        Liebre liebre = new Liebre();
        Tortuga tortuga = new Tortuga();

        Reloj reloj = new Reloj();
        reloj.start();

        try{
            Thread.sleep(300000);//lo que dura la carrera
        }catch(InterruptedException e){
            reloj.interrupt();
            System.err.println(e.getMessage());
            System.out.println("La tortuga a corrido " + tortuga.getCorrido() + "\nLa liebre a corrido " + liebre.getCorrido());
        }


    }
}