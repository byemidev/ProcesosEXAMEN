class MiHilo extends Thread{
    private String nombre;
    MiHilo(String name)
    {
        this.nombre=name;
    }
    @Override
    public void run() {
        System.out.println(nombre);
    }

}

public class EjemploHilo2 {
    public static void main(String[] args) {
        MiHilo hilo1=new MiHilo("hilo1");
        MiHilo hilo2=new MiHilo("hilo2");
        MiHilo hilo3=new MiHilo("hilo3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
}
