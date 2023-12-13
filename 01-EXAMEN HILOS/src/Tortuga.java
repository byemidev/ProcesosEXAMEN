//La tortuga debe hacer ciclos infinitos hasta que le manden parar
//En cada ciclo ejecutara la siguiente fase (1,5 puntos)
    //Corre 4 kilometros y se duerme entre 1 y 3 segundos.
public class Tortuga {
    private String name;
    private int corrido;

    public void setCorrido(int corrido){
            this.corrido = corrido;
    }
    public int getCorrido(){
        return this.corrido;
    }
    public tortuga(){
        this.name = "tortuga";
    }

    public void run(){
        int corrido = 0;
        if(!isInterrupted()){
            while(true){
                corrido += 4;
                setCorrido(corrido);
                int aleatorio = (int)(Math.random()*(3-1+1)+1);
                try{Thread.sleep(aleatorio);
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
