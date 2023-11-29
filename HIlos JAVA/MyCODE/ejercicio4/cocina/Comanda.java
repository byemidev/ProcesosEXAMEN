package ejercicio4.cocina;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comanda extends Thread {

    private List<Map.Entry<String, HashMap<String, Integer>>> platosProcesados = new ArrayList<>();

    public void run() {
        Menu menu;

        while (!Thread.interrupted()) {
            menu = new Menu();
            HashMap<String, HashMap<String, Integer>> platosAleatorios = menu.platosAleatorios();
            final int MAX_HILOS_SIMULTANEOS = 3;
            int numPlatos = platosAleatorios.size();

            Cocina[] cocinas = new Cocina[MAX_HILOS_SIMULTANEOS];
            int numCocinas = cocinas.length;
            int i = 0;
            int hilosActivos = 0;
            boolean interrupcion = false; // Variable auxiliar para salir de todos los bucles en caso de interrupcion
            for (Map.Entry<String, HashMap<String, Integer>> entry : platosAleatorios.entrySet()) {
                HashMap<String, HashMap<String, Integer>> comanda = new HashMap<>();
                comanda.put(entry.getKey(), entry.getValue());
                cocinas[hilosActivos] = new Cocina(comanda);
                cocinas[hilosActivos].start();
                i++;
                hilosActivos++;

                /* Verificar si se han creado el maximo de hilos simultaneos (multiplos de 3)
                o si ya se han creado todos los hilos */
                if (i % numCocinas == 0 || i == numPlatos) {
                    for (int j = 0; j < hilosActivos; j++) {
                        try {
                            cocinas[j].join();
                            /* Se utiliza addAll porque al hacer platosProcesados = cocina.getPlatosProcesados()
                            se sobreescribe en cada comanda */
                            platosProcesados.addAll(cocinas[j].getPlatosProcesados());
                        } catch (InterruptedException e) {
                            System.out.println("Cerramos comandas");
                            interrupcion = true;
                            break;
                        }
                    }
                    hilosActivos = 0;
                }

                // Interrumpir todas las cocinas si se recibe una interrupcion
                if (interrupcion) {
                    for (Cocina c : cocinas) {
                        if (c != null) {
                            c.interrupt();
                        }
                    }
                    break;
                }
            }
            if (interrupcion) break;
        }
        System.out.println("Cerramos comandas");
    }

    public List<Map.Entry<String, HashMap<String, Integer>>> getPlatosProcesados() {
        return platosProcesados;
    }
}