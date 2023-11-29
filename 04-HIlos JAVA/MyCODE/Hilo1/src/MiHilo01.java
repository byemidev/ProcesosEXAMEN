//ejemplo clase Hilos1
class MiHilo extends Thread{
    //este metodo
    public void run(){//run
        try{
            for (int i = 0; i <=5; i++){
                System.out.println(i);
                Thread.sleep(1000); //dormmir por un segundo
            }
        }catch (InterruptedException ie){
            System.err.println("error >> el hijo fue interrumpido " + ie.getMessage());
        }
    }

    public static void main(String[] args) {//main
        MiHilo hilo1 = new MiHilo();

    }
}