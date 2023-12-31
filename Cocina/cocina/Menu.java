package ejercicio4.cocina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Menu {
    private HashMap<String, HashMap<String, Integer>> platos;

    Menu() {
        this.platos = new HashMap<>();
        this.platos.put("Tostada", datosPlato(3000, 3));
        this.platos.put("Sopa Instantánea", datosPlato(5000, 6));
        this.platos.put("Ensalada de Frutas", datosPlato(2000, 8));
        this.platos.put("Sándwich de Queso", datosPlato(4000, 5));
        this.platos.put("Huevos Revueltos", datosPlato(3000, 10));
        this.platos.put("Yogur con Granola", datosPlato(1000, 2));
        this.platos.put("Batido de Proteínas", datosPlato(1000, 3));
        this.platos.put("Café Instantáneo", datosPlato(1000, 2));
        this.platos.put("Avena Instantánea", datosPlato(5000, 4));
        this.platos.put("Té", datosPlato(2000, 2));
    }

    private static HashMap<String, Integer> datosPlato(int tiempo, int precio) {
        HashMap<String, Integer> datosPlato = new HashMap<>();
        datosPlato.put("Tiempo", tiempo);
        datosPlato.put("Precio", precio);
        return datosPlato;
    }

    public HashMap<String, HashMap<String, Integer>> platosAleatorios() {
        HashMap<String, HashMap<String, Integer>> pAleatorios = new HashMap<>();

        // Convertir las claves del HashMap en una lista
        List<String> listaPlatos = new ArrayList<>(platos.keySet());
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();

        // Determinar cuántos platos seleccionar (entre 1 y 5)
        int cantidadPlatos = random.nextInt(5) + 1; // +1 para incluir 5

        // Seleccionar y mostrar los platos aleatorios
        for (int i = 0; i < cantidadPlatos; i++) {
            int indiceAleatorio = random.nextInt(listaPlatos.size());
            String platoSeleccionado = listaPlatos.get(indiceAleatorio);
            pAleatorios.put(platoSeleccionado, platos.get(platoSeleccionado));
        }

        return pAleatorios;
    }
}
