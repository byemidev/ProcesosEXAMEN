
class Liebre extends Thread
{   
    private int distancia;
    Liebre()
    {
        distancia=0;
    }
    public int getDistancia()
    {
        return distancia;
    }

    public void run()
    {
        while(!Thread.interrupted())
        {
            //primera fase
            distancia+=40;
            
            int dormirse = (int)Math.floor(Math.random()*15+5);
             try {
                System.out.println("Liebre distancia:"+distancia+" duermo "+dormirse+"s");
                Thread.sleep(dormirse*1000);
            } catch (InterruptedException e) {
                break;
            }
            //segunda fase
            distancia+=40;
            dormirse = (int)Math.floor(Math.random()*30+20);
             try {
                System.out.println("Liebre distancia:"+distancia+" duermo "+dormirse+"s");
                Thread.sleep(dormirse*1000);
            } catch (InterruptedException e) {
                break;
            }
            

        }
    }
}

class Tortuga extends Thread{
    private int dist;
    
    Tortuga()
    {
        dist=0;
    }
    public int getDistancia()
    {
        return dist;
    }
    public void run()
    {
        while(!Thread.interrupted())
        {
            
            //primera fase
            dist+=4;
            int dormirse = (int)Math.floor(Math.random()*3+1);
             try {
                System.out.println("Tortuga distancia:"+dist+" duermo "+dormirse+"s");
                Thread.sleep(dormirse*1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class reloj extends Thread
{
    private Liebre liebre;
    private Tortuga tortuga;
    reloj(Liebre l,Tortuga t)
    {
        liebre=l;
        tortuga=t;
    }
    public void  run()
    {
        
        int carrera=30;
        for(int i=0;i<carrera;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
        
                e.printStackTrace();
            }
        }
        
        //Paramos la carreta
        liebre.interrupt();
        tortuga.interrupt();
    }
}

public class hilos
{
    public static void main(String[] args) {
        Liebre l=new Liebre();
        Tortuga t=new Tortuga();
        reloj re=new reloj(l,t);
        l.start();
        t.start();
        re.start();
        try {
            re.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("distancia liebre"+l.getDistancia());
        System.out.println("distancia tortuga"+t.getDistancia());
        String ganador=(l.getDistancia()>t.getDistancia())?"liebre":"tortuga";
        System.out.println("El ganador es: "+ganador);
    }
}