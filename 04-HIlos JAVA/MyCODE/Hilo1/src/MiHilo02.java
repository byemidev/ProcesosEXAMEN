//ejemplo clase hilos 2
class MiHilo02 extends Thread{
    private String nombre;
    MiHilo02(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run(){
        System.out.println(this.nombre);
    }

    public static void main(String[] args) {

        MiHilo02 hilo1 = new MiHilo02("hilo1");
        MiHilo02 hilo2 = new MiHilo02("hilo2");
        MiHilo02 hilo3 = new MiHilo02("hilo3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
