public class Reloj extends Thread{
private String name;
//El hilo reloj debe hacer un bucle y a cada ciclo debe dormirse un segundo cuando acabe de mandar
//una interrupción a la liebre y a la tortuga para que paren. (1punto)
    public reloj() extends Thread{
        this.name = "reloj";
    }
    public void run(){
        tortuga tortuga = new tortuga();
        liebre liebre = new liebre();
        while(true){
            liebre.start();
            tortuga.start();
            //se debe evaluar quien a terminado antes
            sleep(1000);
        }
        try{
            liebre.join();
            tortuga.join();
        }catch{
            // TODO Auto-generated catch block
            System.out.println("terminar liebre y tortuga");
            liebre.interrupt();
            tortuga.interrupt();
            break;
        }
    }

}
