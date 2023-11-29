
/*
* @Author Emilio Arevalo
*Practica 01 - Hilos
* Java OpenJDK 21.*
* IDE Intellij IDEA
*/

import java.util.ArrayList;
import java.util.List;

class ActHilo01 extends Thread{
    private String nombre;

    public ActHilo01(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "ActHilo01{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
    @Override
    public void run() {
        int numRand;
        numRand = (int) (Math.random() * 8) + 3; //genero un numero aleatorio entre 3 y 8 como longitud del bucle
        for(int i = 0; i < numRand; i++){
            try { //genero un numero aleatorio entre 1 y 7, estara dentro del for por que me interesa que duerma cada proceso de forma aleatoria por cada iteracion en el bucle
                int tiempo = (int)((Math.random() * 7) +1) * 1000;
                sleep(tiempo);
                System.out.println("Mi nombre es " + getNombre() + "he domido ZzzZ --> " + tiempo +
                        " segundos");

            } catch (InterruptedException e) { //sleep arroja una exception, puede que un hilo no pueda dormirse si estan usando algo que necesita o que lo haya hecho antes de tiempo.
                System.err.println("error de interrupcion...");
            }
        }
    }

    public static void main(String[] args) {
        //Creo una lista de hilos
        List<ActHilo01> lsHilos = new ArrayList<>();
        //Creo una lista de nombres para cada hilo
        String [] lsNombres = {"BlackMelon", "YellowChocolate", "WitheOrange", "BlueBubble", "GreenPeace"};

        //por cada  nombre creo una instancia de mi clase ActHilo01 == Thread
        for (String n : lsNombres) {
            lsHilos.add(new ActHilo01(n));
        }

        //usamos el metodo start() por cada hilo de mi lista de hilos.
        for(ActHilo01 hilo : lsHilos ){
            hilo.start();
        }
    }

}
/*
    Tomando la base del ejemplo 2.

        1. Hilo.

        El hilo debe tener un nombre significativo.
        Debe ejecutar un bucle un numero de veces aleatorio entre 3 y 8 veces.
        En cada pasada del bucle, debe dormise un intervalo aleatorio entre 1 y 7 segundos. y debe imprimir su nombre y el tiempo que se ha dormido.

        2. Programa principal

        Debes crear un array de 5 nombres.
        Debes recorrer el array y en cada iteraccion debes crear y arrancar un hilo nuevo pasandole el nombre como argumento.

        Para dormir usar Threads.sleep() en milisegundo;*/
