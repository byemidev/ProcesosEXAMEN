//Liebre debe ejecutar ciclos infinitos hasta que les manden parar. 
//A cada ciclo siclo simula una hora, cada ciclo tiene dos fases: (1,5 puntos)
    //1ra fase aumenta el numero de kilometros en 20, se duerme entre 5 y 15 segundos
    //2da fase corre otros 20km y se duerme entre 20 y 30segundos.

import java.util.List;

public class Liebre extends Thread{
    private String name;
    private int corrido; 

    public void setCorrido(int corrido){
        this.corrido = corrido;
    }

    public int getCorrido(){
        return this.corrido;
    }
    public void liebre(){
        this.name = "liebre";
    }
    public void run(){
        
        if(!isInterrupted()){
            while(true){
                for(int i= 0; i < 2; i++ ){
                    if(i==1){

                    }else{
                        
                    }
                }
            }
        }
    }

    public static void runCiclo1(){
        //todo
        int corrido = 0;
        int aleatorio = (int)(Math.random()*(15-5+1)+5);
        this.setCorrido(corrido+=20);
        try{
            Thread.sleep(aleatorio);
        }catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }

    public static void runCiclo2(){
        //todo
    }
}