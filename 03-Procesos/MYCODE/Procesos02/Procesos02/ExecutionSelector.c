#include <stdlib.h>


int 
main(){

  char *programas = {'Programa1', 'Programa2'};  //creo un array de strings para almacenar los nombres de mis dos programas
  
  for(int i = 0 ; i < 2 ; i++) // inicializo un bucle , necesito que se ejecute dos veces
  {
    char comando[60]; //creo un string o cadena de 60 caracteres 
    sprintf(comando,"gcc %s.c -o %s", programas[i],programas[i]); //uso sprintf para formatear la instruccion y lo guardo en comando
    if(system(comando) == 0) //si la compilacion del comando es igual a 0, exitosa , entra a mi condicion
    {
      sprintf(comando, ./%s, programas[i]);// estoy modificando el valor de comando, indicando ejecute el programa 1 o 2 en el formateo de la cadena  
      system(comando); //ejecuto el comando con system 
    }
    
  }

  return 0;
}