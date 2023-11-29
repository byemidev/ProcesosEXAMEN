package cocina;


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
        
        
    }
    
}
