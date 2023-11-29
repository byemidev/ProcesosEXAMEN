package cocina;

import java.util.HashMap;
import java.util.Map;

public class Cocina extends Thread{
    private HashMap<String, Integer> comanda;
    Cocina(HashMap<String, Integer> platos)
    {
        this.comanda=platos;
    }
    public void run()
    {
        //cocino los platos
        for (Map.Entry<String, Integer> entrada : comanda.entrySet()) {
            System.out.println("Cocinando plato "+entrada.getKey()+" tiempo "+entrada.getValue());
            try {
                Thread.sleep(entrada.getValue());
            } catch (InterruptedException e) {
               
                System.out.println("Plato sin terminar "+entrada.getKey());
                //salgo del hilo
                break;
            }
            System.out.println("Plato terminado"+entrada.getKey());
            
        }

    }
}
