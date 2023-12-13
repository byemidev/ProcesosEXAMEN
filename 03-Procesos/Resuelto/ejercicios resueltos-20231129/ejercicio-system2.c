/*
Crear un array de urls minimo 3

Crea un programa parecido al de compilator pero ejecute firefox y chrome(chromium) con cada uno de las ulrs
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
    /*Creamos un array con los programas.
    */
    char* urls[] = {
        "https://www.google.es/",
        "https://www.yahoo.es/",
        "https://www.bing.es/"
    };
    size_t tamano = sizeof(urls)/sizeof(urls[0]);
    for(int i = 0; i < tamano; i++) {
        char chrome[200]="chrome ";
        char firefox[200]="firefox ";
        strcat(chrome,urls[i]);
        strcat(firefox,urls[i]);
        system(chrome);
        system(firefox);

    }



}