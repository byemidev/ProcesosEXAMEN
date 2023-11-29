class Dato
{
    private int dato;
    Dato()
    {
        dato=0;
    }
    public void incrementar()
    {
        this.dato++;
    }
    public void decrementar()
    {
        this.dato--;
    }
    public int mostrar()
    {
        return dato;
    }

}

class Hilo extends Thread
{
    private Dato dato;
    private String nombre;
    Hilo(String nombre, Dato dato)
    {
        this.nombre=nombre;
        this.dato=dato;
    }
    
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("hilo "+nombre+" dato antes"+dato.mostrar());
            //Numero aleatorio entre dos valores
            //Math.floor(Math.random() * (MAX - MIN + 1)) + MIN;
            if ((Math.floor(Math.random() * (100000-0+1)) + 0)<50000)
                dato.incrementar();
            else
                dato.decrementar();   
            //numero aleatorio dormir entre 1 y 3 segudno
            try{

                Thread.sleep((int) (Math.floor(Math.random() * (3000 - 0 + 1)) + 0));
            }catch(Exception e){System.out.println(e);}
            System.out.println("hilo "+nombre+" dato despues"+dato.mostrar());

        }
    }
}

public class EjemploCompatir2{
    
    public static void main(String[] args) {
        Dato d=new Dato();
        Hilo hilo1=new Hilo("hilo1",d);
        Hilo hilo2=new Hilo("hilo2",d);
        Hilo hilo3=new Hilo("hilo3",d);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
    }

    
}
