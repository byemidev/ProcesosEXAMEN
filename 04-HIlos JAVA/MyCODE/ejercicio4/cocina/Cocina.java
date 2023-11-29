package ejercicio4.cocina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cocina extends Thread {
    private HashMap<String, HashMap<String, Integer>> comanda;
    private List<Map.Entry<String, HashMap<String, Integer>>> platosProcesados;

    Cocina(HashMap<String, HashMap<String, Integer>> platos) {
        this.comanda = platos;
        platosProcesados = new ArrayList<>();
    }

    public void run() {

        //cocino los platos
        for (Map.Entry<String, HashMap<String, Integer>> entrada : comanda.entrySet()) {
            System.out.println("Cocinando plato " + entrada.getKey() + " tiempo " + entrada.getValue().get("Tiempo"));
            try {
                Thread.sleep(entrada.getValue().get("Tiempo"));
            } catch (InterruptedException e) {
                System.out.println("Plato sin terminar " + entrada.getKey());
                //salgo del hilo
                break;
            }
            System.out.println("Plato terminado " + entrada.getKey());
            platosProcesados.add(entrada);
        }
    }

    public List<Map.Entry<String, HashMap<String, Integer>>> getPlatosProcesados() {
        return platosProcesados;
    }
}
