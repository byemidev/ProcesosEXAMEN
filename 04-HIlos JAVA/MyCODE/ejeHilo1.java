/*
 * Tomando la base del ejemplo 2.

1. Hilo.

El hilo debe tener un nombre significativo.
Debe ejecutar un bucle un numero de veces aleatorio entre 3 y 8 veces.
En cada pasada del bucle, debe dormise un intervalo aleatorio entre 1 y 7 segundos. y debe imprimir su nombre y el tiempo que se ha dormido.
2. Programa principal

Debes crear un array de 5 nombres.
Debes recorrer el array y en cada iteraccion debes crear y arrancar un hilo nuevo pasandole el nombre como argumento.
Para dormir usar Threads.sleep() en milisegundo;
 */
import java.util.Random;

class Hilo extends Thread
{
    private String nombre;
    Hilo(String name)
    {
        this.nombre=name;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public void run()
    {
        Random random = new Random();
        // Generar un número aleatorio entre 3 y 8
        int iteracciones = 3 + random.nextInt(6); 
        // 6 es el número de posibles valores (8 - 3 + 1)

        for (int i = 0; i < iteracciones; i++) {
            int dormir=1 + random.nextInt(8);
            System.out.println("Hilo nombre"+getNombre()+" tiempo "+dormir);
            try {
                Thread.sleep(dormir*1000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }

    }
}

public class ejeHilo1
{
    public static void main(String[] args) {
        String[] nombres={"hilo1","hilo2","hilo3","hilo4","hilo5"};
         
        for(int i=0;i< nombres.length;i++)
        {
            Hilo hilo=new Hilo(nombres[i]);
            hilo.start();

        }
    }
}