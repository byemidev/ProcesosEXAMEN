/*
1. Usa los ejemplos como base. Haz un programa en C que haga los siguiente
Busque todos los ficheros del disco duro que tengan permisos 777 y guardalo en un fichero peligrosos.txt (usa find y la opcion perm)
Si el resultado del comando anterior abre el fichero usando un editor de texto instalado en ordenador pluma o gedit
Abre un firefox con una pagina que exista.
*/

#include <stdlib.h>
#include <stdio.h>
int main() {
    //Busca los ficheros 777
    //Mando los errores a la papelera para que no se muestren por pantalla 
    system("find / -perm 777 > peligrosos.txt 2>/dev/null");
    system("pluma peligrosos.txt");
    return 0;
}