#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
    /*Creamos un array con los programas.
    */
    char* programas[] = {
        "hola",
        "adios"
    };
    size_t tamano = sizeof(programas)/sizeof(programas[0]);
    //printf("Tamano %ld\n",tamano);
    // Usar un bucle para compilar
    for(int i = 0; i < tamano; i++) {
        char cadena[200]="";
        //añadimos el compilador
        strcat(cadena,"gcc ");
        //añadimos el progrma
        strcat(cadena,programas[i]);
        //añadimos la extension
        strcat(cadena,".c");
        //Para cambiar el destino
        strcat(cadena," -o ");
        //creamos el ejecutable
        strcat(cadena,programas[i]);
        system(cadena);

    }

    // Usar un bucle para Ejecutar
    for(int i = 0; i < tamano; i++) {
        char cadena[100]="";
        //Para poder ejecutar el programa
        strcat(cadena,"./");
        strcat(cadena,programas[i]);
        system(cadena);
        printf("\n");
    }

    
    return 0;
}