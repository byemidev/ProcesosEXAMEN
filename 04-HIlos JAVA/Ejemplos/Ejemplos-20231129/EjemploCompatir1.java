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

public class EjemploCompatir1 extends Thread{
    private Dato dato;
    private String nombre;
    EjemploCompatir1(String nombre, Dato dato)
    {
        this.nombre=nombre;
        this.dato=dato;
    }
    
    public void run()
    {
        for(int i=0;i<7;i++)
        {
            System.out.println("hilo "+nombre+" dato antes"+dato.mostrar());
            if (Math.random()*100+1%2==0)
                dato.incrementar();
            else
                dato.decrementar();   
            //numero aleatorio dormir entre 1 y 3 segudno
            try{

                Thread.sleep((int) (Math.random()*3000+1000));
            }catch(Exception e){System.out.println(e);}
            System.out.println("hilo "+nombre+" dato despues"+dato.mostrar());

        }
    }
    public static void main(String[] args) {
        Dato d=new Dato();
        EjemploCompatir1 hilo1=new EjemploCompatir1("hilo1",d);
        EjemploCompatir1 hilo2=new EjemploCompatir1("hilo2",d);
        hilo1.start();
        hilo2.start();
        
    }

    
}
