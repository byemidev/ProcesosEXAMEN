package cocina;


public class Comanda extends Thread{
    
    public void run()
    {
        Menu menu;
        Cocina cocina;

        while(!Thread.interrupted())
        {
           menu=new Menu();
           cocina=new Cocina(menu.platosAleatorios());
            cocina.start();
            //esperamos a que termine de prepara los platos
            try {
                cocina.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("Cerramos comandas");
                cocina.interrupt();
                break;
            }
    
        }
        System.out.println("Cerramos comandas");
        
    }
}

