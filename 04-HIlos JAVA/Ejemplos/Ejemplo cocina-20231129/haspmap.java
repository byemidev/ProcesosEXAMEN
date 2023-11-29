import java.util.HashMap;
 class dato{
        public int tiempo;
        public int precio;
        dato(int t,int p)
        {
            tiempo=t;
            precio=p;
        }


    }

public class haspmap
{

   
    public static void main(String[] args) {
        
        HashMap<String,dato> datos=new HashMap<>();
        datos.put("plato1", new dato(10000,5));
        datos.put("plato2", new dato(30000,15));
        datos.put("plato3", new dato(10000,5));

        for(String clave:datos.keySet())
        {
            System.out.println("clave " +clave+ " tiempo "+datos.get(clave).tiempo+" precio "+datos.get(clave).precio);
            
        }

          
    }
    
}