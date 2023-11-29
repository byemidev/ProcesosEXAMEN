class bloqueador1 extends Thread
{
    private Thread otroHilo;
    public void setHilo(Thread h)
    {
        this.otroHilo=h;
    }
    public void run()
    {
        System.out.println("Bloqueador1 iniciado");
        try
        {
            //espero que acabe el otro hilo para empezar
            otroHilo.join();
        } catch(InterruptedException e){
            System.out.println("Bloqueador1 Interrupción")
        }

    }
}

class bloqueador2 extends Thread
{
    private Thread otroHilo;
    public void setHilo(Thread h)
    {
        this.otroHilo=h;
    }
    public void run()
    {
        System.out.println("Bloqueador2 iniciado");
        try
        {
            //espero que acabe el otro hilo para empezar
            otroHilo.join();
        } catch(InterruptedException e){
            System.out.println("Bloqueador2 Interrupción")
        }

    }
}


public class EjemploJoinInterbloqueo
{
    public static void main(String[] args)
    {
        bloqueador1 hilo1=new bloqueador1();
        bloqueador2 hilo2=new bloqueador2();
        hilo1.setHilo(hilo2);
        hilo2.setHilo(hilo1);
        hilo1.start();
        hilo2.start();
    }

}
