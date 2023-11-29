package ejercicio4.cocina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Comanda comanda=new Comanda();
        comanda.start();
        //Simulo el tiempo apertura.
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        comanda.interrupt();

        // Obtener todos los platos procesados
        List<Map.Entry<String, HashMap<String, Integer>>> platosProcesados = comanda.getPlatosProcesados();

        // Contar el numero de platos y el precio total
        int numPlatos = 0;
        int precioTotal = 0;
        for (Map.Entry<String, HashMap<String, Integer>> plato : platosProcesados) {
            numPlatos++;
            precioTotal += plato.getValue().get("Precio");
        }

        System.out.println("Numero total de platos: "+numPlatos);
        System.out.println("Precio total: "+precioTotal+"€");
    }
}