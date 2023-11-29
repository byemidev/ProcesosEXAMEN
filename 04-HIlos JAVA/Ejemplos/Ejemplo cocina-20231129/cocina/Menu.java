package cocina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Menu {
    private  HashMap<String, Integer> platos;
    Menu()
    {
        this.platos=new HashMap<>();
        this.platos.put("Tostada", 3000);
        this.platos.put("Sopa Instantánea", 5000);
        this.platos.put("Ensalada de Frutas", 2000);
        this.platos.put("Sándwich de Queso", 4000);
        this.platos.put("Huevos Revueltos", 3000);
        this.platos.put("Yogur con Granola", 1000);
        this.platos.put("Batido de Proteínas", 2000);
        this.platos.put("Café Instantáneo", 1000);
        this.platos.put("Avena Instantánea", 5000);
        this.platos.put("Té", 2000);
    }
    public HashMap<String, Integer> platosAleatorios()
    {
        HashMap<String, Integer> pAleatorios=new HashMap<>();

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
            pAleatorios.put(platoSeleccionado,platos.get(platoSeleccionado));
        }

        return pAleatorios;

    } 

    
}
